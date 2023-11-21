package fontys.sem3.school.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidCuisineException extends ResponseStatusException {
    public InvalidCuisineException() {
        super(HttpStatus.BAD_REQUEST, "CUISINE_INVALID");
    }

}
