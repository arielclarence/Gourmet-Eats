package fontys.sem3.school.persistence;

import fontys.sem3.school.persistence.entity.ChatEntity;
import fontys.sem3.school.persistence.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import fontys.sem3.school.persistence.entity.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<ChatEntity, Long> {

    List<ChatEntity> findByCustomerid_Id(long customerId);
    List<ChatEntity> findBySellerid_Id(long sellerId);

    Optional<ChatEntity> findByCustomerid_IdAndSellerid_Id(long customerId, long sellerId);
}
