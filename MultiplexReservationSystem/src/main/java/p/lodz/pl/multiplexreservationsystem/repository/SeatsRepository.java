package p.lodz.pl.multiplexreservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import p.lodz.pl.multiplexreservationsystem.model.Seats;

import java.util.List;

@Repository
public interface SeatsRepository extends JpaRepository<Seats, Long> {
  @Query("Select s From Seats s Where s.roomId = :roomId and s not in :bookedSeats")
  List<Seats> getRoomsAvailableSeats(@Param("roomId") Long roomId, @Param("bookedSeats") List<Seats> bookedSeats);

  List<Seats> findByRoomId(Long roomId);

  @Query("Select s From BookedSeat b left join Seats s on (s.id = b.seatId)" +
          "Where s.roomId = :roomId and b.screeningId = :screeningId")
  List<Seats> getRoomsBookedSeats(@Param("roomId") Long roomId, @Param("screeningId")  Long screeningId);
}
