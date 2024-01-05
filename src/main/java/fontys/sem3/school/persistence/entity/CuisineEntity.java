package fontys.sem3.school.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "cuisine")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CuisineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotBlank
    @Length(min = 2, max = 50)
    @Column(name = "name")
    private String name;


    @NotBlank
    @Length(min = 2, max = 255)
    @Column(name = "pictureUrl")
    private String pictureUrl;
}
