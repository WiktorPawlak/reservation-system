package p.lodz.pl.multiplexreservationsystem.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import p.lodz.pl.multiplexreservationsystem.model.Screenings;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScreeningsRepository extends JpaRepository<Screenings, Long> {
  @Query("Select s, m.title, m.duration From Screenings s left join Movies m on s.movieId = m.id")
  List<Object[]> findAllScreeningsJoinMovies(Pageable page);

  @Query("Select s, m.title, m.duration From Screenings s left join Movies m on (s.movieId = m.id)" +
          "Where s.date >= :from and s.date <= :to")
  List<Object[]> findAllScreeningsWithinPeriod(@Param("from") LocalDateTime from,
                                               @Param("to") LocalDateTime to, Pageable page);
}
