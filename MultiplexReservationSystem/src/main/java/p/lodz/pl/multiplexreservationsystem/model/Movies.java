package p.lodz.pl.multiplexreservationsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class Movies {
  @Id
  private long id;
  private String title;
  private LocalTime duration;
}
