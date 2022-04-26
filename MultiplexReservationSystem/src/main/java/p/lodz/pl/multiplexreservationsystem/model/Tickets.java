package p.lodz.pl.multiplexreservationsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Tickets {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "reservation_id")
  @JsonBackReference
  @EqualsAndHashCode.Exclude
  private Reservations reservation;
  @NotNull
  private long seatId;
  @NotNull
  private TicketType type;
}
