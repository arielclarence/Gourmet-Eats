package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.FoodUseCase;
import fontys.sem3.school.business.UserValidator;
import fontys.sem3.school.business.exception.InvalidUserException;
import fontys.sem3.school.business.exception.UserNotFoundException;
import fontys.sem3.school.domain.*;
import fontys.sem3.school.persistence.ChatRepository;
import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.FoodRepository;
import fontys.sem3.school.persistence.UserRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import fontys.sem3.school.persistence.entity.FoodEntity;
import fontys.sem3.school.persistence.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class FoodUseCaseImpl implements FoodUseCase {
    private final FoodRepository foodRepository;
    private final CuisineRepository cuisineRepository;

    private final UserValidator foodIdValidator;
    private final UserRepository userRepository;



    @Override
    public void softdeleteFood(long foodid) {

        this.foodRepository.updateStatusByFoodId(foodid,false);
    }

    @Override
    public GetAllFoodsResponse getFoods() {
        List<Food> Foods = foodRepository.findAll()
                .stream()
                .map(FoodConverter::convert)
                .toList();

        return GetAllFoodsResponse.builder()
                .Foods(Foods)
                .build();
    }

    @Override
    public CreateFoodResponse createFood(CreateFoodRequest request) {
        FoodEntity savedFood = saveNewFood(request);

        return CreateFoodResponse.builder()
                .Id(savedFood.getId())
                .build();
    }
    private FoodEntity saveNewFood(CreateFoodRequest request) {
        UserEntity seller=getUser(request.getSellerid());
CuisineEntity cuisine=getCuisine(request.getCuisineid());
        FoodEntity newFood = FoodEntity.builder()
                .seller(seller)
                .name(request.getName())
                .code(generateFoodCode(request.getName()))
                .description(request.getDescription())
                .pictureUrl(request.getPictureUrl())
                .totalsales(0L)
                .price(request.getPrice())
                .cuisine(cuisine)
                .build();
        return foodRepository.save(newFood);
    }
    @Override
    public Optional<Food> getFood(long FoodId) {
        return foodRepository.findById(FoodId).map(FoodConverter::convert);

    }
    @Override
    public GetAllFoodsResponse getFoodsbyCuisineId(long cuisineId) {

        List<Food> Foods = foodRepository.findByCuisine_IdAndStatus(cuisineId,true)
                .stream()
                .map(FoodConverter::convert)
                .toList();

        return GetAllFoodsResponse.builder()
                .Foods(Foods)
                .build();
    }

    @Override
    public void updateFood(UpdateFoodRequest request) {
        Optional<FoodEntity> FoodOptional = foodRepository.findById(request.getId());


        foodIdValidator.validateFoodId(request.getId());

        if (FoodOptional.isPresent()) {
            FoodEntity food = FoodOptional.get();
            updateFieldsProfile(request, food);
        } else {
            throw new InvalidUserException("FOOD_ID_INVALID");

        }
    }

    private String generateFoodCode(String foodName) {
        // Take the first three letters of the item name
        String prefix = foodName.substring(0, Math.min(foodName.length(), 3)).toUpperCase();

        // Get the count of existing items in the database
        long foodCount = foodRepository.count();

        // Generate the 5-digit sequence
        String sequenceValue = String.format("%05d", foodCount + 1);

        // Concatenate the parts to form the item code
        return prefix + "_" + sequenceValue;
    }
    private void updateFieldsProfile(UpdateFoodRequest request, FoodEntity Food) {
        Food.setName(request.getName());
        Food.setDescription(request.getDescription());
        Food.setCode(generateFoodCode(request.getName()));
        foodRepository.save(Food);
    }
    private UserEntity getUser(long userId) {
        Optional<UserEntity>user=userRepository.findById(userId);
        if (user.isEmpty()){
            throw new UserNotFoundException();
        }
        return user.get();
    }
    private CuisineEntity getCuisine(long userId) {
        Optional<CuisineEntity>cuisine=cuisineRepository.findById(userId);
        if (cuisine.isEmpty()){
            throw new UserNotFoundException();
        }
        return cuisine.get();
    }

}
