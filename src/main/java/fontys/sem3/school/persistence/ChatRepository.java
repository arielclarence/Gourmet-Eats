package fontys.sem3.school.persistence;

import fontys.sem3.school.persistence.entity.ChatEntity;
import fontys.sem3.school.persistence.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

    List<ChatEntity> findByCustomerid(long customerid);
    List<ChatEntity> findBySellerid(long sellerid);

    Optional<ChatEntity> findByCustomeridAndSellerid(long customerId, long sellerId);
}
