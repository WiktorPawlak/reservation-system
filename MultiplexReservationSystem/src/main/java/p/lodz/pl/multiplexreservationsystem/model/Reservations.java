package p.lodz.pl.multiplexreservationsystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Reservations {
  @Id
  private long id;
  private long screeningId;
  private String name;
  private String surname;
  private double price;
  private LocalDateTime expirationTime;
}
