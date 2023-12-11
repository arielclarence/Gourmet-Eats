package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.exception.InvalidCredentialsException;
import fontys.sem3.school.configuration.security.token.AccessTokenEncoder;
import fontys.sem3.school.configuration.security.token.impl.AccessTokenImpl;
import fontys.sem3.school.domain.CreateUserRequest;
import fontys.sem3.school.domain.Enum.Role;
import fontys.sem3.school.domain.LoginRequest;
import fontys.sem3.school.domain.LoginResponse;
import fontys.sem3.school.persistence.UserRepository;
import fontys.sem3.school.persistence.entity.UserEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
class LoginUseCaseImplTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private AccessTokenEncoder accessTokenEncoder;

    @InjectMocks
    private LoginUseCaseImpl loginUseCase;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        loginUseCase = new LoginUseCaseImpl(userRepository, passwordEncoder,accessTokenEncoder);
    }
    @Test
    public void testLogin_Successful() {
        // Arrange
        LoginRequest loginRequest = new LoginRequest("johndoe", "johndoe");
        CreateUserRequest userRequest = CreateUserRequest.builder()
                .name("John Doe")
                .username("johndoe")
                .passwordhash("$2a$10$rd3wel7MDAix.dcb3KvXFu3LAF6WSxits6m7PmRUizlbQC63vqgsO")
                .phonenumber("1234567890")
                .address("123 Main St")
                .role(Role.Customer)
                .gender("Male")
                .birthdate(LocalDate.now())
                .build();
        UserEntity user = UserEntity.builder()
                .id(1L) // Mocked or actual ID returned by the database
                .name(userRequest.getName())
                .username(userRequest.getUsername())
                .passwordhash(userRequest.getPasswordhash())
                .phonenumber(userRequest.getPhonenumber())
                .address(userRequest.getAddress())
                .role(userRequest.getRole())
                .gender(userRequest.getGender())
                .birthdate(userRequest.getBirthdate())
                .build();
        when(userRepository.findByUsername(loginRequest.getUsername())).thenReturn(user);
        when(passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordhash())).thenReturn(true);
        when(accessTokenEncoder.encode(any(AccessTokenImpl.class))).thenReturn("mockedAccessToken");

        // Act
        LoginResponse response = loginUseCase.login(loginRequest);

        // Assert
        assertNotNull(response);
        assertNotNull(response.getAccessToken());
        assertEquals("mockedAccessToken", response.getAccessToken());

        // Verify interactions
        verify(userRepository, times(1)).findByUsername(loginRequest.getUsername());
        verify(passwordEncoder, times(1)).matches(loginRequest.getPassword(), user.getPasswordhash());
        verify(accessTokenEncoder, times(1)).encode(any(AccessTokenImpl.class));
    }

    @Test
    public void testLogin_InvalidUsername() {
        // Arrange
        LoginRequest loginRequest = new LoginRequest("nonexistentUser", "password");
        when(userRepository.findByUsername(loginRequest.getUsername())).thenReturn(null);

        // Act and Assert
        assertThrows(InvalidCredentialsException.class, () -> loginUseCase.login(loginRequest));

        // Verify interactions
        verify(userRepository, times(1)).findByUsername(loginRequest.getUsername());
        verifyNoInteractions(passwordEncoder, accessTokenEncoder);
    }

    @Test
    public void testLogin_InvalidPassword() {
        // Arrange
        LoginRequest loginRequest = new LoginRequest("johndoe", "invalid");
        CreateUserRequest userRequest = CreateUserRequest.builder()
                .name("John Doe")
                .username("johndoe")
                .passwordhash("$2a$10$rd3wel7MDAix.dcb3KvXFu3LAF6WSxits6m7PmRUizlbQC63vqgsO")
                .phonenumber("1234567890")
                .address("123 Main St")
                .role(Role.Customer)
                .gender("Male")
                .birthdate(LocalDate.now())
                .build();
        UserEntity user = UserEntity.builder()
                .id(1L) // Mocked or actual ID returned by the database
                .name(userRequest.getName())
                .username(userRequest.getUsername())
                .passwordhash(userRequest.getPasswordhash())
                .phonenumber(userRequest.getPhonenumber())
                .address(userRequest.getAddress())
                .role(userRequest.getRole())
                .gender(userRequest.getGender())
                .birthdate(userRequest.getBirthdate())
                .build();
        when(userRepository.findByUsername(loginRequest.getUsername())).thenReturn(user);
        when(passwordEncoder.matches(loginRequest.getPassword(), user.getPasswordhash())).thenReturn(false);

        // Act and Assert
        assertThrows(InvalidCredentialsException.class, () -> loginUseCase.login(loginRequest));

        // Verify interactions
        verify(userRepository, times(1)).findByUsername(loginRequest.getUsername());
        verify(passwordEncoder, times(1)).matches(loginRequest.getPassword(), user.getPasswordhash());
        verifyNoInteractions(accessTokenEncoder);
    }
}