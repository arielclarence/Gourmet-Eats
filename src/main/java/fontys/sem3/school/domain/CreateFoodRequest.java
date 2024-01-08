package fontys.sem3.school.domain;

import fontys.sem3.school.domain.Enum.Role;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import fontys.sem3.school.persistence.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateFoodRequest {

    @NotNull
    private UserEntity seller;

    @NotBlank
    @Length(min = 2, max = 50)
    private String name;

    @NotBlank
    @Length(min = 2, max = 255)
    private String description;

    @NotBlank
    @Length(min = 2, max = 255)
    private String pictureUrl;

    @NotNull
    private double price;

    @NotNull
    private CuisineEntity cuisine;

}
