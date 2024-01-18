package fontys.sem3.school.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Table(name = "order_header")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHeaderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "total")
    @NotNull
    @Min(0)
    private double total;

    @Column(name = "user_id")
    @NotNull
    private Long userId;

    public OrderHeaderEntity(double total, Long userId) {
        this.total = total;
        this.userId = userId;
    }
}

