package p.lodz.pl.multiplexreservationsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.lodz.pl.multiplexreservationsystem.model.Tickets;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets, Long> {
}
