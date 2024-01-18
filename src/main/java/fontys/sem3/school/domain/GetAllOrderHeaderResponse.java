package fontys.sem3.school.domain;

import fontys.sem3.school.persistence.entity.OrderDetailEntity;
import fontys.sem3.school.persistence.entity.UserEntity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllOrderHeaderResponse {
    private List<OrderHeader> orderheaders;

}
