package fontys.sem3.school.persistence;

import fontys.sem3.school.persistence.entity.CuisineEntity;

import java.util.List;

public interface CuisineRepository {
//    boolean existsByCode(String code);

    boolean existsById(long cuisineId);

    CuisineEntity findById(long cuisineId);

    CuisineEntity save(CuisineEntity cuisine);

    List<CuisineEntity> findAll();
    void deleteById(long cuisineId);
    int count();
}
