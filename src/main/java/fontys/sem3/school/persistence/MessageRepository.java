package fontys.sem3.school.persistence;

import fontys.sem3.school.persistence.entity.CuisineEntity;
import fontys.sem3.school.persistence.entity.FoodEntity;
import fontys.sem3.school.persistence.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MessageRepository extends JpaRepository<MessageEntity, Long> {

    List<MessageEntity> findByChat_Id(long chatId);

}
