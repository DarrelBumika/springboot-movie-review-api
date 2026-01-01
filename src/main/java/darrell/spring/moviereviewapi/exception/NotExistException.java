package darrell.spring.moviereviewapi.exception;

public class NotExistException extends RuntimeException {
    public NotExistException(String message) {
        super(message);
    }
}
