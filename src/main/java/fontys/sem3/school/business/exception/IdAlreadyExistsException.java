package fontys.sem3.school.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class IdAlreadyExistsException extends ResponseStatusException {
    public IdAlreadyExistsException() {
        super(HttpStatus.BAD_REQUEST, "ID_ALREADY_EXISTS");
    }
}
