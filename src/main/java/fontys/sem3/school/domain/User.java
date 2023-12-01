package fontys.sem3.school.domain;


import fontys.sem3.school.domain.Enum.Role;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
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
//asd
public class User {
    private Long id;


    private String name;


    private String username;


    private String passwordhash;


    private String phonenumber;


    private String address;


    private String gender;


    private String image;
    private Role role;

    private LocalDate birthdate;


    private Long balance;
}
