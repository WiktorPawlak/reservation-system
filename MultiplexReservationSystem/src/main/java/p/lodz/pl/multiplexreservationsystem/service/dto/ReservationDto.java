package p.lodz.pl.multiplexreservationsystem.service.dto;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

@Value
@Builder
public class ReservationDto {
  double price;
  LocalDateTime expirationTime;
}
