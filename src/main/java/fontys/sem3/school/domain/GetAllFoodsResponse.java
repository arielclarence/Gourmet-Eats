package fontys.sem3.school.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class GetAllFoodsResponse {
    private List<Food> Foods;
}
