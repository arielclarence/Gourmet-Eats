package fontys.sem3.school.domain;


import fontys.sem3.school.persistence.entity.FoodEntity;
import fontys.sem3.school.persistence.entity.OrderHeaderEntity;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//asd
public class OrderDetail {
    @NotNull
    private Long id;

    @NotNull
    private Long orderheaderid;

    @NotNull
    private Long foodid;

    @NotNull
    private int amount;

    @NotNull
    private double subtotal;


     private String specialRequest;
}
