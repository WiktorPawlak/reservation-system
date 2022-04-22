package p.lodz.pl.multiplexreservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import p.lodz.pl.multiplexreservationsystem.model.BookedSeat;

import java.util.List;

public interface BookedSeatRepository extends JpaRepository<BookedSeat, Long> {
  @Query("Select b From BookedSeat b left join Screenings s on (b.screeningId = s.id)" +
          "Where s.id = :screeningId")
  List<BookedSeat> getBookedSeats(@Param("screeningId") Long screeningId);
}
