package fontys.sem3.school.persistence;

import fontys.sem3.school.persistence.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
    Optional<UserEntity>findByToken(String token);
    @Modifying
    @Query("UPDATE UserEntity SET token=:token WHERE username=:username")
    void saveToken(@Param("token")String token, @Param("username") String username);
}
