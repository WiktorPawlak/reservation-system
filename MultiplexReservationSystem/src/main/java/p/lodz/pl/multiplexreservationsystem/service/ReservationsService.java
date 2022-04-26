package p.lodz.pl.multiplexreservationsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import p.lodz.pl.multiplexreservationsystem.exceptionHandling.InvalidBusinessArgumentException;
import p.lodz.pl.multiplexreservationsystem.model.*;
import p.lodz.pl.multiplexreservationsystem.repository.BookedSeatRepository;
import p.lodz.pl.multiplexreservationsystem.repository.MoviesRepository;
import p.lodz.pl.multiplexreservationsystem.repository.ReservationsRepository;
import p.lodz.pl.multiplexreservationsystem.repository.TicketsRepository;
import p.lodz.pl.multiplexreservationsystem.service.dto.ReservationDto;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import static p.lodz.pl.multiplexreservationsystem.service.mapper.ReservationsMapper.*;

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

  public Reservations getSingleReservation(long id) {
    return reservationsRepository.findById(id)
            .orElseThrow();
  }

  @Transactional
  public ReservationDto postReservation(Reservations reservation) {
    Screenings screening = screeningsService.getSingleScreening(reservation.getScreeningId());

    if (isTooLateToBook(screening)) {
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

  private boolean isTooLateToBook(Screenings screening) {
    return LocalDateTime.now().isAfter(screening.getDate().minusMinutes(15));
  }

  private boolean isBookingCorrect(long screeningId, long roomId, List<Tickets> tickets) {
    List<Seats> allSeats = seatsService.getRoomsSeats(roomId);
    Set<Seats> seatsToBook = new HashSet<>(); //set for seats uniqueness
    List<Seats> bookedSeats = seatsService.getBookedSeats(roomId, screeningId);
    List<Seats> availableSeats = seatsService.getAvailableSeats(roomId, bookedSeats);

    for (var ticket : tickets) {
      seatsToBook.add(seatsService.getSeatById(ticket.getSeatId()));
    }

    if (seatsToBook.size() != tickets.size()
            || !availableSeats.containsAll(seatsToBook)) {
      return false;
    }

    for (var seat : seatsToBook) {
      if (bookedSeats.contains(seat)) {
        return false;
      }

      if (seat.getSeatNumber() != 1) {
        Seats leftNeighbour = allSeats.get((int) (seat.getId() - 1) - 1);
        if (!seatsToBook.contains(leftNeighbour)
                && !bookedSeats.contains(leftNeighbour)
                && leftNeighbour.getSeatNumber() != 1) {
            Seats secondLeftNeighbour = allSeats.get((int) (leftNeighbour.getId() - 1) - 1);
            if (seatsToBook.contains(secondLeftNeighbour) || bookedSeats.contains(secondLeftNeighbour)) {
              return false;
            }
        }
      }

      if (seat.getSeatNumber() != NO_SEATS_IN_ROW) {
        Seats rightNeighbour = allSeats.get((int) seat.getId());
        if (!seatsToBook.contains(rightNeighbour)
                && !bookedSeats.contains(rightNeighbour)
                && rightNeighbour.getSeatNumber() != 1) {
            Seats secondRightNeighbour = allSeats.get((int) rightNeighbour.getId());
            if (seatsToBook.contains(secondRightNeighbour) || bookedSeats.contains(secondRightNeighbour)) {
              return false;
            }
        }
      }
    }
    return true;
  }
}
