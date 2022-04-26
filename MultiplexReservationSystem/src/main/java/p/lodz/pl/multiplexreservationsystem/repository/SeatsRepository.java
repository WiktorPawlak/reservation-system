package p.lodz.pl.multiplexreservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import p.lodz.pl.multiplexreservationsystem.model.Seats;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, Long> {
  @Query("Select s From Seats s left join BookedSeat b on (s.id = b.seatId)" +
          "Where b.id is null and s.roomId = :roomId")
  List<Seats> getRoomsAvailableSeats(@Param("roomId") Long roomId);

  List<Seats> findByRoomId(Long roomId);
}
