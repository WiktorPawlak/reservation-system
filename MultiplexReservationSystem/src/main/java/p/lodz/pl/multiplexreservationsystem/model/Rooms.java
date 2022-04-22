package p.lodz.pl.multiplexreservationsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Rooms {
  @Id
  private long id;
  @OneToMany
  @JoinColumn(name = "roomId")
  private List<Seats> seats;
}
