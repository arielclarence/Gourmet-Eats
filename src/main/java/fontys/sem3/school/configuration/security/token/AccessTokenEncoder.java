package fontys.sem3.school.configuration.security.token;

public interface AccessTokenEncoder {
    String encode(AccessToken accessToken);
}
