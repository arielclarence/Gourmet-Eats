package fontys.sem3.school.configuration.security.token.impl;

import fontys.sem3.school.configuration.security.token.AccessToken;
import fontys.sem3.school.domain.Enum.Role;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@EqualsAndHashCode
@Getter
public class AccessTokenImpl implements AccessToken {
    private final String subject;
    private final Long studentId;
    private final Role role;

    public AccessTokenImpl(String subject, Long studentId, Role role) {
        this.subject = subject;
        this.studentId = studentId;
        this.role = role ;
    }
}
