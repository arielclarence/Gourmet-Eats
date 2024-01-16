package fontys.sem3.school.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateChatResponse {
    private Long Id;
    private Long Sellerid;
    private Long Customerid;
    private String Sellername;
    private String Customername;
}
