package p.lodz.pl.multiplexreservationsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import p.lodz.pl.multiplexreservationsystem.model.BookedSeat;


public interface BookedSeatRepository extends JpaRepository<BookedSeat, Long> {


}
