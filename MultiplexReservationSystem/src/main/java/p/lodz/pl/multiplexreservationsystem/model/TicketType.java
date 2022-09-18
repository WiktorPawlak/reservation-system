package p.lodz.pl.multiplexreservationsystem.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;


@Getter
@RequiredArgsConstructor
public enum TicketType {

  ADULT(BigDecimal.valueOf(25)),

  STUDENT(BigDecimal.valueOf(18)),
  CHILD(BigDecimal.valueOf(12.5));

  private final BigDecimal price;
}
