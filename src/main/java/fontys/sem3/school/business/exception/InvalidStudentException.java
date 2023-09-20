package fontys.sem3.school.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class InvalidStudentException extends ResponseStatusException {
    public InvalidStudentException(String errorCode) {
        super(HttpStatus.BAD_REQUEST, errorCode);
    }
}