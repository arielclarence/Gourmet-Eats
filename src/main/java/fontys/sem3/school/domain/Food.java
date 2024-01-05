package fontys.sem3.school.domain;


import fontys.sem3.school.domain.Enum.Role;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import fontys.sem3.school.persistence.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//asd
public class Food {
    private Long id;
    private UserEntity seller;
    private String name;
    private String code;
    private String description;
    private String pictureUrl;
    private Long totalSales;
    private boolean status;
    private CuisineEntity cuisine;
}
