package fontys.sem3.school.persistence;

import fontys.sem3.school.persistence.entity.CuisineEntity;

import java.util.List;

public interface CuisineRepository {
//    boolean existsByCode(String code);

    boolean existsById(long countryId);

    CuisineEntity findById(long countryId);

    CuisineEntity save(CuisineEntity country);

    List<CuisineEntity> findAll();
    void deleteById(long cuisineId);
    int count();
}
