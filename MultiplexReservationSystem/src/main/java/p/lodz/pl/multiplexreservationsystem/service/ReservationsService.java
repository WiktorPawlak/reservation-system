package p.lodz.pl.multiplexreservationsystem.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import p.lodz.pl.multiplexreservationsystem.exception.InvalidBusinessArgumentException;
import p.lodz.pl.multiplexreservationsystem.model.BookedSeat;
import p.lodz.pl.multiplexreservationsystem.model.Reservations;
import p.lodz.pl.multiplexreservationsystem.model.Screenings;
import p.lodz.pl.multiplexreservationsystem.model.Seats;
import p.lodz.pl.multiplexreservationsystem.model.Tickets;
import p.lodz.pl.multiplexreservationsystem.repository.BookedSeatRepository;
import p.lodz.pl.multiplexreservationsystem.repository.MoviesRepository;
import p.lodz.pl.multiplexreservationsystem.repository.ReservationsRepository;
import p.lodz.pl.multiplexreservationsystem.repository.TicketsRepository;
import p.lodz.pl.multiplexreservationsystem.service.dto.ReservationDto;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static p.lodz.pl.multiplexreservationsystem.service.mapper.ReservationsMapper.mapToReservationsDto;


@Service
@RequiredArgsConstructor
public class ReservationsService {

    private static final int NO_SEATS_IN_ROW = 5;

    private final ReservationsRepository reservationsRepository;

    private final BookedSeatRepository bookedSeatRepository;

    private final MoviesRepository moviesRepository;


    private final TicketsRepository ticketsRepository;

    private final SeatsService seatsService;

    private final ScreeningsService screeningsService;

    @Transactional
    public ReservationDto postReservation(Reservations reservation) {
        Screenings screening = screeningsService.getSingleScreening(reservation.getScreeningId());

        if (screening.isTooLateToBook()) {
            throw new InvalidBusinessArgumentException("The seats must be booked at least 15 minutes before session.");
        }
        if (!isBookingCorrect(screening.getId(), screening.getRoomId(), reservation.getTickets())) {
            throw new InvalidBusinessArgumentException("There can't be one unoccupied seat in between already booked seats" +
                    " or the seat is already booked");
        }

        bookSeats(reservation.getTickets(), screening.getId());
        LocalDateTime expirationTime = calculateExpirationDate(screening);
        reservation.setExpirationTime(expirationTime);

        reservationsRepository.save(reservation);
        bookTickets(reservation.getTickets());

        return getReservationInfo(reservation);
    }

    public ReservationDto getReservationInfo(Reservations reservation) {
        return mapToReservationsDto(reservation);
    }

    private void bookSeats(List<Tickets> tickets, Long screeningId) {
        for (var ticket : tickets) {
            bookedSeatRepository.save(new BookedSeat(ticket.getSeatId(), screeningId));
        }
    }

    private void bookTickets(List<Tickets> tickets) {
        ticketsRepository.saveAll(tickets);
    }

    private LocalDateTime calculateExpirationDate(Screenings screening) {
        LocalTime movieDuration = moviesRepository.findById(screening.getMovieId()).orElseThrow().getDuration();
        return screening.getDate().plusHours(movieDuration.getHour())
                .plusMinutes(movieDuration.getMinute());
    }

    private boolean isBookingCorrect(long screeningId, long roomId, List<Tickets> tickets) {
        List<Seats> allSeats = seatsService.getRoomsSeats(roomId);
        Set<Seats> seatsToBook = new HashSet<>(); //set for seats uniqueness
        for (var ticket : tickets) {
            seatsToBook.add(seatsService.getSeatById(ticket.getSeatId()));
        }
        List<Seats> bookedSeats = seatsService.getBookedSeats(roomId, screeningId);
        List<Seats> availableSeats = seatsService.getAvailableSeats(roomId, bookedSeats);


        if (seatsToBook.size() != tickets.size()
                || !new HashSet<>(availableSeats).containsAll(seatsToBook)) {
            return false;
        }

        for (var seat : seatsToBook) {
            if (bookedSeats.contains(seat)
                    || !searchLeftNeighbours(allSeats, seatsToBook, bookedSeats, seat)
                    || !searchRightNeighbours(allSeats, seatsToBook, bookedSeats, seat)) {
                return false;
            }
        }
        return true;
    }

    private boolean searchLeftNeighbours(List<Seats> allSeats, Set<Seats> seatsToBook,
                                         List<Seats> bookedSeats, Seats seat) {
        if (seat.getSeatNumber() != 1) {
            Seats leftNeighbour = allSeats.stream().filter(s -> s.getId() == (seat.getId() - 1))
                    .findFirst().orElseThrow();

            if (!seatsToBook.contains(leftNeighbour)
                    && !bookedSeats.contains(leftNeighbour)
                    && leftNeighbour.getSeatNumber() != 1) {
                Seats secondLeftNeighbour = allSeats.stream().filter(s -> s.getId() == (leftNeighbour.getId() - 1))
                        .findFirst().orElseThrow();

                return !seatsToBook.contains(secondLeftNeighbour) && !bookedSeats.contains(secondLeftNeighbour);
            }
        }
        return true;
    }

    private boolean searchRightNeighbours(List<Seats> allSeats, Set<Seats> seatsToBook,
                                          List<Seats> bookedSeats, Seats seat) {
        if (seat.getSeatNumber() != NO_SEATS_IN_ROW) {
            Seats rightNeighbour = allSeats.stream().filter(s -> s.getId() == (seat.getId() + 1))
                    .findFirst().orElseThrow();

            if (!seatsToBook.contains(rightNeighbour)
                    && !bookedSeats.contains(rightNeighbour)
                    && rightNeighbour.getSeatNumber() != 1) {
                Seats secondRightNeighbour = allSeats.stream().filter(s -> s.getId() == (rightNeighbour.getId() + 1))
                        .findFirst().orElseThrow();

                return !seatsToBook.contains(secondRightNeighbour) && !bookedSeats.contains(secondRightNeighbour);
            }
        }
        return true;
    }
}
