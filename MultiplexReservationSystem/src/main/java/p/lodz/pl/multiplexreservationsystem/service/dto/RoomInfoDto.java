package p.lodz.pl.multiplexreservationsystem.service.dto;


import lombok.Builder;

import java.util.List;


@Builder
public record RoomInfoDto(long id, List<SeatsDto> seats) {

}
