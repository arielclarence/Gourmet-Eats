package fontys.sem3.school.persistence;

import fontys.sem3.school.domain.OrderHeader;
import fontys.sem3.school.persistence.entity.ChatEntity;
import fontys.sem3.school.persistence.entity.FoodEntity;
import fontys.sem3.school.persistence.entity.OrderDetailEntity;
import fontys.sem3.school.persistence.entity.OrderHeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderHeaderRepository extends JpaRepository<OrderHeaderEntity, Long> {

    Optional<OrderHeaderEntity> findById(Long OrderHeaderid);
    List<OrderHeaderEntity> findByUserId(Long OrderHeaderid);

}
