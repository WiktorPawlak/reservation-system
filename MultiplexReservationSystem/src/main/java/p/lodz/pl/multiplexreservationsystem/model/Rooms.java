package p.lodz.pl.multiplexreservationsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@Getter
@Setter
public class Rooms {
  @Id
  private long id;
  @ElementCollection
  private List<Seats> seats;
}
