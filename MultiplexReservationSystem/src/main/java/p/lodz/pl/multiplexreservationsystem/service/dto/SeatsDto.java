package p.lodz.pl.multiplexreservationsystem.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor
public class SeatsDto {
  int row;
  int seatNumber;
}
