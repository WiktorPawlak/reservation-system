package p.lodz.pl.multiplexreservationsystem.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
public class Screenings {

    private static final int RESERVED_MINUTES_BEFORE_SCREENING = 15;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long movieId;

    private long roomId;

    @NotNull
    private LocalDateTime date;

    public boolean isTooLateToBook() {
        return LocalDateTime.now().isAfter(getDate().minusMinutes(RESERVED_MINUTES_BEFORE_SCREENING));
    }
}
