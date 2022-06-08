package p.lodz.pl.multiplexreservationsystem.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Value
@Builder
@AllArgsConstructor
public class ScreeningsDto {
  //long id;
  //long movieId;
  //long roomId;
  //LocalDateTime date;
  String title;
  LocalTime duration;
}
