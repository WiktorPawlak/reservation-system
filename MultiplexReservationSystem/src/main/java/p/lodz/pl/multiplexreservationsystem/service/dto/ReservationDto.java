package p.lodz.pl.multiplexreservationsystem.service.dto;


import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Builder
public record ReservationDto(BigDecimal price, LocalDateTime expirationTime) {

}
