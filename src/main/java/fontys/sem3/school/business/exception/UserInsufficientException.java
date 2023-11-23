package fontys.sem3.school.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UserInsufficientException extends ResponseStatusException {
    public UserInsufficientException(String errorCode) {

        super(HttpStatus.BAD_REQUEST, errorCode);
    }
}