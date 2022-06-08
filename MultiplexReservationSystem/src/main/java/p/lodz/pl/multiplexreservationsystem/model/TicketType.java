package p.lodz.pl.multiplexreservationsystem.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TicketType {
  ADULT(25),
  STUDENT(18),
  CHILD(12.5);

  private final double price;
}
