package fontys.sem3.school.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsernameAlreadyExistsException extends ResponseStatusException {
    public UsernameAlreadyExistsException() {
        super(HttpStatus.BAD_REQUEST, "USERNAME_ALREADY_EXISTS");
    }
}
