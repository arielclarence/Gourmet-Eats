package fontys.sem3.school.domain;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
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
public class UpdateUserRequest {
    @NotNull
    private Long id;
    @NotBlank
    private String name;

    @NotBlank
    private String username;

    @NotBlank
    private String passwordhash;

    @NotBlank
    private String phonenumber;

    @NotBlank
    private String address;

    @NotBlank
    private String gender;


    private String image;

    @NotNull
    @Past(message = "Birthdate must be in the past")
    private LocalDate birthdate;


}
