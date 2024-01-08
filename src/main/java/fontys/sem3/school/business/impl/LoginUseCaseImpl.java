package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.LoginUseCase;
import fontys.sem3.school.business.exception.InvalidCredentialsException;
import fontys.sem3.school.configuration.security.token.AccessTokenEncoder;
import fontys.sem3.school.configuration.security.token.impl.AccessTokenImpl;
import fontys.sem3.school.domain.Enum.Role;
import fontys.sem3.school.domain.LoginRequest;
import fontys.sem3.school.domain.LoginResponse;
import fontys.sem3.school.persistence.UserRepository;
import fontys.sem3.school.persistence.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AccessTokenEncoder accessTokenEncoder;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        UserEntity user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null) {
            throw new InvalidCredentialsException();
        }

        if (!matchesPassword(loginRequest.getPassword(), user.getPasswordhash())) {
            throw new InvalidCredentialsException();
        }
//        if (!Objects.equals(loginRequest.getPassword(), user.getPasswordhash())) {
//            throw new InvalidCredentialsException();
//        }
        String accessToken = generateAccessToken(user);
        return LoginResponse.builder().accessToken(accessToken).build();
    }

    private boolean matchesPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    private String generateAccessToken(UserEntity user) {

        String role = String.valueOf(user.getRole());


        return accessTokenEncoder.encode(
                new AccessTokenImpl(user.getUsername(), user.getId(), role, user.getProfilePictureUrl()));
    }

}
