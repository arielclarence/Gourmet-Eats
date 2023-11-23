package fontys.sem3.school.business;

import fontys.sem3.school.domain.LoginRequest;
import fontys.sem3.school.domain.LoginResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest loginRequest);
}
