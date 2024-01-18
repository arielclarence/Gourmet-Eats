package fontys.sem3.school.domain;

import lombok.*;

@Getter
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RefreshTokenResponse {
    String token;
}
