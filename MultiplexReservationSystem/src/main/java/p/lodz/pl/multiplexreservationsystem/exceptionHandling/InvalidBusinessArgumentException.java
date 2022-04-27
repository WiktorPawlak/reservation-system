package p.lodz.pl.multiplexreservationsystem.exceptionHandling;

public class InvalidBusinessArgumentException extends RuntimeException{
  public InvalidBusinessArgumentException(String message) {
    super(message);
  }
}
