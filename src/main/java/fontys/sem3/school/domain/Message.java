package fontys.sem3.school.domain;

import fontys.sem3.school.persistence.entity.ChatEntity;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import fontys.sem3.school.persistence.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private long id;

    private UserEntity senderid;

    private String content;

    private LocalDateTime timestamp;

    private ChatEntity chatid;
}
