package p.lodz.pl.multiplexreservationsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Reservations {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private long screeningId;
  private String name;
  private String surname;
  private LocalDateTime expirationTime;
  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "reservation_id", updatable = false, insertable = false)
  @JsonManagedReference
  private List<Tickets> tickets;
}
