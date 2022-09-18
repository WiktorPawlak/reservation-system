package p.lodz.pl.multiplexreservationsystem.service.mapper;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import p.lodz.pl.multiplexreservationsystem.model.Seats;
import p.lodz.pl.multiplexreservationsystem.service.dto.RoomInfoDto;
import p.lodz.pl.multiplexreservationsystem.service.dto.SeatsDto;

import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SeatsDtoMapper {
    public static List<SeatsDto> mapToSeatsDtos(List<Seats> roomsAvailableSeats) {
        return roomsAvailableSeats.stream()
                .map(SeatsDtoMapper::mapToSeatsDto)
                .toList();
    }

    public static SeatsDto mapToSeatsDto(Seats roomsAvailableSeat) {
        return SeatsDto.builder()
                .row(roomsAvailableSeat.getRowNumber())
                .seatNumber(roomsAvailableSeat.getSeatNumber())
                .build();
    }

    public static RoomInfoDto mapToRoomInfoDto(Long roomId, List<SeatsDto> availableSeats) {
        return RoomInfoDto.builder()
                .id(roomId)
                .seats(availableSeats)
                .build();
    }
}
