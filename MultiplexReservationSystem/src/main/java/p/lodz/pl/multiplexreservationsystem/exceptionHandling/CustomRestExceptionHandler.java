package p.lodz.pl.multiplexreservationsystem.exceptionHandling;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(final MethodArgumentNotValidException exception,
                                                                final HttpHeaders headers,
                                                                final HttpStatus status, final WebRequest request) {
    final List<String> errors = new ArrayList<>();

    for (final FieldError error : exception.getBindingResult().getFieldErrors()) { //getBinding - Return the results of the failed validation.
      errors.add(error.getField() + " : " + error.getDefaultMessage());
    }

    for (final ObjectError error : exception.getBindingResult().getGlobalErrors()) {
      errors.add(error.getObjectName() + " : " + error.getDefaultMessage());
    }

    ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, exception.getLocalizedMessage(), errors);

    return handleExceptionInternal(exception, apiError, headers, apiError.getStatus(), request);
  }

  @ExceptionHandler(InvalidBusinessArgumentException.class)
  public final ResponseEntity<Object> handleInvalidBusinessArgumentException(
          InvalidBusinessArgumentException exception) {
    final HttpStatus status = HttpStatus.NOT_ACCEPTABLE;

    final String error = "Status Code: " + status.value() + ", Exception: InvalidBusinessArgumentException";

    final ApiError apiError = new ApiError(status, exception.getLocalizedMessage(), error);

    return new ResponseEntity<>(apiError, new HttpHeaders(), status);
  }
}
