package p.lodz.pl.multiplexreservationsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Tickets {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reservation_id")
  @JsonBackReference
  private Reservations reservation;
  private long seatId;
  private TicketType type;
}
