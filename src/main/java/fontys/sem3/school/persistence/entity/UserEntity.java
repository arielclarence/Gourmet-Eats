package fontys.sem3.school.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@Table(name = "user")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    @Column(name = "username")
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
    @Length(max = 50)
    @Column(name = "address") // Specify the column type and length
    private String address;

    @NotBlank
    @Length(max = 30)
    @Column(name = "gender")
    private String gender;


    @NotBlank
    @Column(name = "birthdate")
    private Date birthdate;


    @NotBlank
    @Length(min = 2 ,max = 50)
    @Column(name = "image")
    private String image;

    @NotBlank
    @Length(min = 2 ,max = 50)
    @Column(name = "balance")
    private Long balance;

}
