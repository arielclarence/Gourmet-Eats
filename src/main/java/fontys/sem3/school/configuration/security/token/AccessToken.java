package fontys.sem3.school.configuration.security.token;

import fontys.sem3.school.domain.Enum.Role;

import java.util.Set;

public interface AccessToken {
    String getSubject();

    Long getUserid();

    String getRole();

}
