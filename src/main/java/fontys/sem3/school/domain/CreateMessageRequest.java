package fontys.sem3.school.domain;

import fontys.sem3.school.persistence.entity.ChatEntity;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import fontys.sem3.school.persistence.entity.UserEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMessageRequest {

    @NotNull
    private long senderid;

    @NotBlank
    private String content;

    @NotNull
    private long chatid;

}
