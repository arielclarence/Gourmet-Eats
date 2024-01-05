package fontys.sem3.school.business;

import fontys.sem3.school.domain.*;

import java.util.Optional;

public interface FoodUseCase {
    void softdeleteFood(long cuisineId);

    GetAllFoodsResponse getFoods();

    CreateFoodResponse createFood(CreateFoodRequest request);
    Optional<Food> getFood(long UserId);
    GetAllFoodsResponse getFoodsbyCuisineId(long cuisineId);

    void updateFood(UpdateFoodRequest request);
}
