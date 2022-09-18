package p.lodz.pl.multiplexreservationsystem.service.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

import java.time.LocalTime;


@Value
@Builder
@AllArgsConstructor
public class ScreeningsDto {

    String title;

    LocalTime duration;
}
