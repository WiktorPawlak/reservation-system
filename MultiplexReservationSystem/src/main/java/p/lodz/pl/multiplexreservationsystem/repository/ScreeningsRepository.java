package p.lodz.pl.multiplexreservationsystem.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import p.lodz.pl.multiplexreservationsystem.model.Screenings;

import java.util.List;

@Repository
public interface ScreeningsRepository extends JpaRepository<Screenings, Long> {
  @Query("Select s From Screenings s")
  List<Screenings> findAllScreenings(Pageable page);

  @Query("Select s, m.title, m.duration From Screenings s left join Movies m on s.movieId = m.id")
  List<Object[]> findAllScreeningsJoinMovies(Pageable page);
}
