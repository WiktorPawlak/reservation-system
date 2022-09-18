package p.lodz.pl.multiplexreservationsystem.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Value
@Builder
@AllArgsConstructor
public class ReservationDto {

  BigDecimal price;

  LocalDateTime expirationTime;
}
