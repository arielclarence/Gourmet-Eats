package fontys.sem3.school.persistence;

import fontys.sem3.school.domain.OrderDetail;
import fontys.sem3.school.persistence.entity.FoodEntity;
import fontys.sem3.school.persistence.entity.OrderDetailEntity;
import fontys.sem3.school.persistence.entity.OrderHeaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity, Long> {

    List<OrderDetailEntity> findByOrderHeader_Id(Long OrderHeaderid);

    @Query("SELECT SUM(od.subtotal) FROM OrderDetailEntity od JOIN od.food f JOIN f.seller s WHERE s.id = :sellerId")
    Double findTotalSubtotalBySellerId(@Param("sellerId") Long sellerId);
}
