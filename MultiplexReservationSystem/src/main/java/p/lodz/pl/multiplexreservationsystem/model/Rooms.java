package p.lodz.pl.multiplexreservationsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Rooms {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @OneToMany
  @JoinColumn(name = "roomId", updatable = false, insertable = false)
  private List<Seats> seats;
}
