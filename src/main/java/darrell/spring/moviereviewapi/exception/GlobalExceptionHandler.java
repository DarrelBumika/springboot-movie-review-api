package darrell.spring.moviereviewapi.exception;

import darrell.spring.moviereviewapi.dto.error.ErrorResponse;
import darrell.spring.moviereviewapi.utils.ErrorResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExistException(AlreadyExistException e) {
        return ErrorResponseBuilder.build(
                HttpStatus.CONFLICT,
                "Data Already Exists",
                e
        );
    }

    @ExceptionHandler(NotExistException.class)
    public ResponseEntity<ErrorResponse> handleNotExistException(NotExistException e) {
        return ErrorResponseBuilder.build(
                HttpStatus.NOT_FOUND,
                "Data Not Found",
                e
        );
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsernameNotFoundException(UsernameNotFoundException e) {
        return ErrorResponseBuilder.build(
                HttpStatus.NOT_FOUND,
                "User Not Found",
                e
        );
    }
}

