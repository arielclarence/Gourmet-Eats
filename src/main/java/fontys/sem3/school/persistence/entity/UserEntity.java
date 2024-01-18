package fontys.sem3.school.persistence.entity;

import fontys.sem3.school.domain.Enum.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "user")
@Data
@Builder
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "name")
    private String name;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "username", unique = true)
    private String username;

    @NotBlank
    @Length(max = 60)
    @Column(name = "password_hash")
    private String passwordhash;

    @NotBlank
    @Length(max = 15)
    @Column(name = "phonenumber") // Specify the column type and length
    private String phonenumber;

    @NotBlank
    @Email(message = "Please provide a valid email address")
    @Column(name = "email", unique = true)
    private String email;

    @NotBlank
    @Length(max = 50)
    @Column(name = "address") // Specify the column type and length
    private String address;

    @NotBlank
    @Length(max = 30)
    @Column(name = "gender")
    private String gender;

    @Length(max = 255)
    @Column(name = "profilePictureUrl")
    private String profilePictureUrl;

    @NotNull
    @Column(name = "role")
    private Role role;

    @NotNull
    @Past(message = "Birthdate must be in the past")
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @NotNull
    @Min(0)
    private Long balance;

    @Column(name = "token",columnDefinition = "TEXT")
    private String token;

    public UserEntity() {
        this.balance = 0L; // Set the initial value to 0
    }
}
