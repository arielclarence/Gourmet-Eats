package fontys.sem3.school.domain;

import fontys.sem3.school.persistence.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateChatRequest {
    @NotNull
    private Long customerid;

    @NotNull
    private Long sellerid;
}
