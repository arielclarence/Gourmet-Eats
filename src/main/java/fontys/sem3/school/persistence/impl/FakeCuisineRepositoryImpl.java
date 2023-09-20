package fontys.sem3.school.persistence.impl;

import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class FakeCuisineRepositoryImpl implements CuisineRepository {
    private static long NEXT_ID = 1;

    private final List<CuisineEntity> savedCuisine;

    public FakeCuisineRepositoryImpl() {
        this.savedCuisine = new ArrayList<>();
    }

//    @Override
//    public boolean existsByCode(String code) {
//        return this.savedCuisine
//                .stream()
//                .anyMatch(cuisineEntity -> cuisineEntity.getCode().equals(code));
//    }

    @Override
    public boolean existsById(long cuisineId) {
        return this.savedCuisine
                .stream()
                .anyMatch(cuisineEntity -> cuisineEntity.getId() == cuisineId);
    }

    @Override
    public CuisineEntity findById(long cuisineId) {
        return this.savedCuisine
                .stream()
                .filter(cuisineEntity -> cuisineEntity.getId() == cuisineId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public CuisineEntity save(CuisineEntity cuisine) {
        cuisine.setId(NEXT_ID);
        NEXT_ID++;
        this.savedCuisine.add(cuisine);
        return cuisine;
    }
    @Override
    public void deleteById(long cuisineId) {
        this.savedCuisine.removeIf(cuisineEntity -> cuisineEntity.getId()== cuisineId);
    }
    @Override
    public List<CuisineEntity> findAll() {
        return Collections.unmodifiableList(savedCuisine);
    }

    @Override
    public int count() {
        return this.savedCuisine.size();
    }
}
