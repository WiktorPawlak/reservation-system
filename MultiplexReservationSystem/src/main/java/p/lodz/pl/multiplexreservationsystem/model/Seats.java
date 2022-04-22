package p.lodz.pl.multiplexreservationsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Seats {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private int seatNumber;
  private long roomId;
}
