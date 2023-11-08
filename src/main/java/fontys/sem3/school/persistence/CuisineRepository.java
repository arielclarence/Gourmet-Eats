package fontys.sem3.school.persistence;

import fontys.sem3.school.persistence.entity.CuisineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CuisineRepository extends JpaRepository<CuisineEntity, Long> {
//    boolean existsByCode(String code);

    boolean existsById(long cuisineId);

//    CuisineEntity findById(long cuisineId);

//    CuisineEntity save(CuisineEntity cuisine);

//    List<CuisineEntity> findAll();
//    void deleteById(long cuisineId);
//    int count();
}
