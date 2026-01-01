package darrell.spring.moviereviewapi.utils;

import darrell.spring.moviereviewapi.dto.error.ErrorResponse;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

public class ErrorResponseBuilder {

    public static ResponseEntity<ErrorResponse> build(
            HttpStatusCode Status,
            String error,
            Exception e

    ) {
        return ResponseEntity.status(Status).body(new ErrorResponse(
                Status.value(),
                error,
                e.getMessage()
        ));
    }

}
