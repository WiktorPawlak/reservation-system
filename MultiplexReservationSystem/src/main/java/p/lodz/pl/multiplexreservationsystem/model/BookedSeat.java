package p.lodz.pl.multiplexreservationsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class BookedSeat {
  @Id
  private long id;
  private long seatId;
  private long screeningId;
}
