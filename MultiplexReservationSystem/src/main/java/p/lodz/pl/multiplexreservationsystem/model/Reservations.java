package p.lodz.pl.multiplexreservationsystem.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
public class Reservations {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  @NotNull(message = "Reservation must have its screening.")
  private long screeningId;
  @NotEmpty(message = "Name must not be empty.")
  @Pattern(regexp = "^\\p{IsUppercase}[\\p{IsAlphabetic}]{2,}$",
          message = "Name should be at least three characters long, " +
                  "start with a capital letter and consist only of alphabetic characters.")
  private String name;
  @NotEmpty(message = "Surname must not be empty.")
  @Pattern(regexp = "^\\p{IsUppercase}[\\p{IsAlphabetic}]{2,}$|^\\p{IsUppercase}[\\p{IsAlphabetic}]+-\\p{IsUppercase}[\\p{IsAlphabetic}]{2,}$",
          message = "Surname should be at least three characters long, " +
                  "start with a capital letter and consist only of alphabetic characters." +
                  " If surname consists of two parts it must be separated with a single dash.")

  private String surname;
  private LocalDateTime expirationTime;
  @OneToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "reservation_id", updatable = false, insertable = false)
  @JsonManagedReference
  @NotEmpty(message = "The reservation must comprise of at least one ticket(seat)")
  private List<Tickets> tickets;
}
