package p.lodz.pl.multiplexreservationsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import p.lodz.pl.multiplexreservationsystem.model.Seats;
import p.lodz.pl.multiplexreservationsystem.repository.ScreeningsRepository;
import p.lodz.pl.multiplexreservationsystem.repository.SeatsRepository;
import p.lodz.pl.multiplexreservationsystem.service.dto.RoomInfoDto;
import p.lodz.pl.multiplexreservationsystem.service.dto.SeatsDto;

import java.util.List;

import static p.lodz.pl.multiplexreservationsystem.service.mapper.SeatsDtoMapper.*;

@Service
@RequiredArgsConstructor
public class SeatsService {
  private final ScreeningsRepository screeningsRepository;
  private final SeatsRepository seatsRepository;

  public RoomInfoDto getRoomInfo(Long id) {
    Long roomId = screeningsRepository.findById(id).orElseThrow().getRoomId();
    return mapToRoomInfoDto(roomId, getAvailableSeatsDtos(roomId));
  }

  public Seats getSeatById(long id) {
    return seatsRepository.findById(id).orElseThrow();
  }

  public List<SeatsDto> getAvailableSeatsDtos(Long roomId) {
    return mapToSeatsDtos(seatsRepository.getRoomsAvailableSeats(roomId));
  }

  public List<Seats> getAvailableSeats(Long roomId) {
    return seatsRepository.getRoomsAvailableSeats(roomId);
  }

  public List<Seats> getRoomsSeats(Long roomId) {
    return seatsRepository.findByRoomId(roomId);
  }
}
