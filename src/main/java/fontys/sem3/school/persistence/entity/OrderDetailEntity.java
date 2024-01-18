package fontys.sem3.school.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "order_detail")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "food_id")
    @ToString.Exclude
    private FoodEntity food;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "order_header_id")
    @ToString.Exclude
    private OrderHeaderEntity orderHeader;

    @Column(name = "amount")
    @NotNull
    @Min(1)
    private int amount;

    @Column(name = "subtotal")
    @NotNull
    @Min(0)
    private double subtotal;

    @Column(name = "special_request")
    @NotBlank
    @Length(min = 2, max = 255)
    private String specialRequest;

}