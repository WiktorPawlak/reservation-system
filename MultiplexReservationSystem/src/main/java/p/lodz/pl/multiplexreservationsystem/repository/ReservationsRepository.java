package p.lodz.pl.multiplexreservationsystem.repository;


import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import p.lodz.pl.multiplexreservationsystem.model.Reservations;

import java.util.List;


@Repository
public interface ReservationsRepository extends JpaRepository<Reservations, Long> {
  
    @Query("Select r From Reservations r")
    List<Reservations> findAllReservations(Pageable page);
}
