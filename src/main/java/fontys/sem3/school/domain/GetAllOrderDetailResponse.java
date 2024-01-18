package fontys.sem3.school.domain;

import fontys.sem3.school.persistence.entity.FoodEntity;
import fontys.sem3.school.persistence.entity.OrderDetailEntity;
import fontys.sem3.school.persistence.entity.OrderHeaderEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Data
@Builder
public class GetAllOrderDetailResponse {
    private List<OrderDetail> orderdetails;
}
