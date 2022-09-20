package p.lodz.pl.multiplexreservationsystem.service.dto;


import lombok.Builder;

import java.time.LocalTime;


@Builder
public record ScreeningsDto(String title, LocalTime duration) {

}
