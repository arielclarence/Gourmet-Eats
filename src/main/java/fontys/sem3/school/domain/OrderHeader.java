package fontys.sem3.school.domain;


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
public class OrderHeader {
    @NotNull
    private Long id;

    @NotNull
    private int amount;

    @NotNull
    private double total;

    @NotNull
    private Long userid;

}
