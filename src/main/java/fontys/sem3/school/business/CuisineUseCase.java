package fontys.sem3.school.business;

import fontys.sem3.school.domain.*;

import java.util.Optional;

public interface CuisineUseCase {
    void deleteCuisine(long cuisineId);

    GetCuisinesResponse getCuisines();

    CreateCuisineResponse createCuisine(CreateCuisineRequest request);

    Optional<Cuisine> getCuisine(long cuisineId);

    void updateCuisine(UpdateCuisineRequest request);
}
