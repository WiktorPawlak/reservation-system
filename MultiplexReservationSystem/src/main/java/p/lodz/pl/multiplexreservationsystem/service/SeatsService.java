package p.lodz.pl.multiplexreservationsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import p.lodz.pl.multiplexreservationsystem.model.BookedSeat;
import p.lodz.pl.multiplexreservationsystem.model.Seats;
import p.lodz.pl.multiplexreservationsystem.repository.BookedSeatRepository;
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
  private final BookedSeatRepository bookedSeatRepository;

  public RoomInfoDto getRoomInfo(Long id) {
    Long roomId = screeningsRepository.findById(id).orElseThrow().getRoomId();
    List<Seats> bookedSeats = getBookedSeats(roomId, id);
    return mapToRoomInfoDto(roomId, getAvailableSeatsDtos(roomId, bookedSeats));
  }

  public Seats getSeatById(long id) {
    return seatsRepository.findById(id).orElseThrow();
  }

  public List<SeatsDto> getAvailableSeatsDtos(Long roomId, List<Seats> bookedSeats) {
    return mapToSeatsDtos(seatsRepository.getRoomsAvailableSeats(roomId, bookedSeats));
  }

  public List<Seats> getAvailableSeats(Long roomId, List<Seats> bookedSeats) {
    return seatsRepository.getRoomsAvailableSeats(roomId, bookedSeats);
  }

  public List<Seats> getBookedSeats(Long roomId, Long screeningId) {
    return seatsRepository.getRoomsBookedSeats(roomId, screeningId);
  }

  public List<Seats> getRoomsSeats(Long roomId) {
    return seatsRepository.findByRoomId(roomId);
  }
}
