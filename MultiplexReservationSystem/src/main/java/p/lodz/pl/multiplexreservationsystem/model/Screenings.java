package p.lodz.pl.multiplexreservationsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Screenings {
  @Id
  private long id;
  private long movieId;
  private long roomId;
  private LocalDateTime date;
}
