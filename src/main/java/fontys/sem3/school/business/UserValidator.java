package fontys.sem3.school.business;

import fontys.sem3.school.business.exception.InvalidUserException;
import fontys.sem3.school.business.exception.UserInsufficientException;

public interface UserValidator {
    void validateId(Long userID) throws InvalidUserException;
    void validateBalance(Long userID,Long update) throws UserInsufficientException;
    void validateFoodId(Long foodID) throws InvalidUserException;

}
