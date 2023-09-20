package fontys.sem3.school.persistence.entity;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Builder
@Data
public class CuisineEntity {

    private long id;
    private String cuisineName;
}
