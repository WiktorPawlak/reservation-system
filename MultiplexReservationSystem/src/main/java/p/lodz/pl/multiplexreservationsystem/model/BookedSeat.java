package p.lodz.pl.multiplexreservationsystem.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class BookedSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long seatId;
    private long screeningId;

    public BookedSeat(long seatId, long screeningId) {
        this.seatId = seatId;
        this.screeningId = screeningId;
    }
}
