package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.UserValidator;
import fontys.sem3.school.business.exception.InvalidUserException;
import fontys.sem3.school.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserValidatorImpl implements UserValidator {
    private final UserRepository userRepository;

    @Override
    public void validateId(Long UserId) {
        if (UserId == null || !userRepository.existsById(UserId)) {
            throw new InvalidUserException("USER_ID_INVALID");
        }
    }
    @Override
    public void validateBalance(Long UserBalance,Long Update) {
        if (UserBalance-Update<0) {
            throw new InvalidUserException("USER_BALANCE_INSUFFICIENT");
        }
    }
}
