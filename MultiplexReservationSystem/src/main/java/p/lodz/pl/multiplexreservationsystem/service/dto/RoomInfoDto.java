package p.lodz.pl.multiplexreservationsystem.service.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class RoomInfoDto {
  long id;
  List<SeatsDto> seats;
}
