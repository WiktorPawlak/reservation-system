package p.lodz.pl.multiplexreservationsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import p.lodz.pl.multiplexreservationsystem.model.Reservations;
import p.lodz.pl.multiplexreservationsystem.repository.ReservationsRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationsService {
  private static final int PAGE_SIZE = 4;
  private final ReservationsRepository reservationsRepository;

  public List<Reservations> getReservations(int page) {
    return reservationsRepository.findAllReservations(PageRequest.of(page, PAGE_SIZE));
  }

  public Reservations getSingleReservation(long id) {
    return reservationsRepository.findById(id)
            .orElseThrow();
  }
}
