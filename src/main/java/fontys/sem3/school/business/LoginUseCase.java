package fontys.sem3.school.business;

import fontys.sem3.school.domain.LoginRequest;
import fontys.sem3.school.domain.LoginResponse;
import fontys.sem3.school.domain.RefreshTokenRequest;
import fontys.sem3.school.domain.RefreshTokenResponse;

public interface LoginUseCase {
    LoginResponse login(LoginRequest loginRequest);
    RefreshTokenResponse refreshToken(RefreshTokenRequest request);
}
