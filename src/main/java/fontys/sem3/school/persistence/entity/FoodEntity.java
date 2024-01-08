package fontys.sem3.school.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.bind.DefaultValue;


@Entity
@Table(name = "food")
@Builder
@Data
@AllArgsConstructor
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "seller_id")
    @ToString.Exclude
    private UserEntity seller;

    @NotBlank
    @Length(min = 2 ,max = 50)
    @Column(name = "name")
    private String name;

    @NotNull
    @Length(min = 9, max = 9)
    @Column(name = "code")
    private String code;

    @NotBlank
    @Length(min = 2, max = 255)
    @Column(name = "description")
    private String description;

    @NotBlank
    @Length(min = 2 ,max = 255)
    @Column(name = "pictureUrl")
    private String pictureUrl;


    @Column(name = "totalsales")
    @NotNull
    @Min(0)
    @Max(99999999)
    private Long totalsales;

    @Column(name = "price")
    @NotNull
    @Min(0)
    private double price;

    @Column(name = "status")
    @NotNull
    private boolean status;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    @ToString.Exclude
    private CuisineEntity cuisine;

    public FoodEntity() {
        this.totalsales = 0L;
        this.status=true;
    }
}
