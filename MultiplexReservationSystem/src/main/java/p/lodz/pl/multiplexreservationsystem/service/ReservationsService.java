package p.lodz.pl.multiplexreservationsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import p.lodz.pl.multiplexreservationsystem.model.BookedSeat;
import p.lodz.pl.multiplexreservationsystem.model.Reservations;
import p.lodz.pl.multiplexreservationsystem.model.Screenings;
import p.lodz.pl.multiplexreservationsystem.model.Tickets;
import p.lodz.pl.multiplexreservationsystem.repository.BookedSeatRepository;
import p.lodz.pl.multiplexreservationsystem.repository.MoviesRepository;
import p.lodz.pl.multiplexreservationsystem.repository.ReservationsRepository;
import p.lodz.pl.multiplexreservationsystem.repository.TicketsRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationsService {
  private static final int PAGE_SIZE = 4;

  private final ReservationsRepository reservationsRepository;
  private final BookedSeatRepository bookedSeatRepository;
  private final MoviesRepository moviesRepository;
  private final TicketsRepository ticketsRepository;

  private final ScreeningsService screeningsService;

  public List<Reservations> getReservations(int page) {
    return reservationsRepository.findAllReservations(PageRequest.of(page, PAGE_SIZE));
  }

  public Reservations getSingleReservation(long id) {
    return reservationsRepository.findById(id)
            .orElseThrow();
  }

  @Transactional
  public Reservations postReservation(Reservations reservation) {
    //TODO::check for 15 minutes before session
    //TODO::check for seats availability
    Screenings screening = screeningsService.getSingleScreening(reservation.getScreeningId());

    bookSeats(reservation.getTickets(), screening.getId());
    LocalDateTime expirationTime = calculateExpirationDate(screening);
    reservation.setExpirationTime(expirationTime);

    reservationsRepository.save(reservation);
    bookTickets(reservation.getTickets());

    return reservation;
  }

  private void bookSeats(List<Tickets> tickets, Long screeningId) {
    for (var ticket : tickets) {
      bookedSeatRepository.save((new BookedSeat(ticket.getSeatId(), screeningId)));
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
}
