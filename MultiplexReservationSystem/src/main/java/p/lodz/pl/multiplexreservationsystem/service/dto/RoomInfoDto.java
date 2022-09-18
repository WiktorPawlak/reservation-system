package p.lodz.pl.multiplexreservationsystem.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.util.List;


@Value
@Builder
@AllArgsConstructor
public class RoomInfoDto {

  long id;

  List<SeatsDto> seats;
}
