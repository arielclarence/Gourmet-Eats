package fontys.sem3.school.domain;

import fontys.sem3.school.persistence.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    private long id;


    private UserEntity customerid;


    private UserEntity sellerid;
    private String sellername;
    private String customername;
    private LocalDateTime updatedAt;
}
