package p.lodz.pl.multiplexreservationsystem.service.mapper;

import p.lodz.pl.multiplexreservationsystem.model.Reservations;
import p.lodz.pl.multiplexreservationsystem.service.dto.ReservationDto;

public class ReservationsMapper {
  public static ReservationDto mapToReservationsDto(Reservations reservation) {
    return ReservationDto.builder()
            .expirationTime(reservation.getExpirationTime())
            .price(getTotalPrice(reservation))
            .build();
  }

  private static double getTotalPrice(Reservations reservation) {
    double totalPrice = 0;
    for (var ticket : reservation.getTickets()) {
      totalPrice += ticket.getType().getPrice();
    }
    return totalPrice;
  }
}
