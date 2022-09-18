package p.lodz.pl.multiplexreservationsystem.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import p.lodz.pl.multiplexreservationsystem.model.Movies;


@Repository
public interface MoviesRepository extends JpaRepository<Movies, Long> {


}
