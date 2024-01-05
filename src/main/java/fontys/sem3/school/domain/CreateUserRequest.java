package fontys.sem3.school.domain;

import fontys.sem3.school.domain.Enum.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {
//    @NotNull
//    @Min(1)
//    @Max(100000)
//    private Long id;

    @NotBlank
    @Length(min = 2, max = 50)
    private String name;

    @NotBlank
    @Length(min = 2, max = 50)
    private String username;

    @NotBlank
    @Length(max = 60)
    private String passwordhash;

    @NotBlank
    @Length(max = 15)
    private String phonenumber;

    @NotBlank
    @Length(max = 50)
    private String email;

    @NotBlank
    @Length(max = 50)
    private String address;

    @NotNull
    private Role role;

    @NotNull
    private String profilePictureUrl;

    @NotBlank
    @Length(max = 30)
    private String gender;

    @NotNull
    @Past(message = "Birthdate must be in the past")
    private LocalDate birthdate;


}
