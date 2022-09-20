package p.lodz.pl.multiplexreservationsystem.service.dto;


import lombok.Builder;


@Builder
public record SeatsDto(int row, int seatNumber) {

}
