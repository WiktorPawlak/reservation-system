package p.lodz.pl.multiplexreservationsystem.service.mapper;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import p.lodz.pl.multiplexreservationsystem.model.Reservations;
import p.lodz.pl.multiplexreservationsystem.service.dto.ReservationDto;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ReservationsMapper {

    public static ReservationDto mapToReservationsDto(Reservations reservation) {
        return ReservationDto.builder()
                .expirationTime(reservation.getExpirationTime())
                .price(reservation.getTotalPrice())
                .build();
    }
}
