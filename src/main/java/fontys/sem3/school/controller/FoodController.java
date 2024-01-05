package fontys.sem3.school.controller;

import fontys.sem3.school.business.FoodUseCase;
import fontys.sem3.school.business.UserUseCase;
import fontys.sem3.school.domain.*;
import jakarta.annotation.security.RolesAllowed;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/food")
@AllArgsConstructor
public class FoodController {

    private final FoodUseCase foodUseCase;

    @GetMapping
    @RolesAllowed({"Customer","Seller","Admin"})
    public ResponseEntity<GetAllFoodsResponse> getFoods() {

        return ResponseEntity.ok(foodUseCase.getFoods());
    }

    @GetMapping("/{foodId}")
    @RolesAllowed({"Customer","Seller","Admin"})
    public ResponseEntity<Food> getFood(@PathVariable(value = "foodId") final long foodId) {
        final Optional<Food> foodOptional = foodUseCase.getFood(foodId);
        if (foodOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(foodOptional.get());
    }

    @GetMapping("cuisine/{cuisineid}")
    @RolesAllowed({"Customer","Seller","Admin"})
    public ResponseEntity<GetAllFoodsResponse> getFoodbycuisine(@PathVariable(value = "cuisineid") final long cuisineid) {
        GetAllFoodsResponse foods= foodUseCase.getFoodsbyCuisineId(cuisineid);
        return ResponseEntity.ok().body(foods);
    }
    @DeleteMapping("/{foodId}")
    @RolesAllowed({"Seller","Admin"})
    public ResponseEntity<Void> softdeletefood(@PathVariable long foodId) {
        foodUseCase.softdeleteFood(foodId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    @RolesAllowed({"Seller"})
    public ResponseEntity<CreateFoodResponse> createFood(@RequestBody @Valid CreateFoodRequest request) {
        CreateFoodResponse response = foodUseCase.createFood(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{foodId}")
    @RolesAllowed({"Seller","Admin"})
    public ResponseEntity<Void> updateFood(@PathVariable("foodId") long foodId,
                                           @RequestBody @Valid UpdateFoodRequest request) {
        request.setId(foodId);
        foodUseCase.updateFood(request);
        return ResponseEntity.noContent().build();
    }


}
