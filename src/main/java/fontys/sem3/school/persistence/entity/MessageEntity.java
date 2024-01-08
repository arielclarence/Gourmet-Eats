package fontys.sem3.school.persistence.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
@Table(name = "message")
@Builder
@Data
@AllArgsConstructor
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "sender_id")
    @ToString.Exclude
    private UserEntity senderid;

    @NotBlank
    @Length(min = 2, max = 255)
    @Column(name = "content")
    private String content;

    @NotNull
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "chat_id")
    @ToString.Exclude
    private ChatEntity chatid;
    public MessageEntity() {
        this.timestamp = LocalDateTime.now();
        this.chatid.setUpdatedAt(this.timestamp);
    }



}
