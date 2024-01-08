package fontys.sem3.school.persistence.entity;
import fontys.sem3.school.domain.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "chat")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @ToString.Exclude
    private UserEntity customerid;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "seller_id")
    @ToString.Exclude
    private UserEntity sellerid;

    @NotNull
    @Column(name = "updatedAt")
    private LocalDateTime updatedAt;
    public String getCustomerName() {
        return customerid.getName(); // Assuming UserEntity has a 'getName()' method
    }

    public String getSellerName() {
        return sellerid.getName(); // Assuming UserEntity has a 'getName()' method
    }
}
