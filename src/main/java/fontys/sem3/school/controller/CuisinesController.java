package fontys.sem3.school.controller;

import fontys.sem3.school.business.DeleteCuisineUseCase;
import fontys.sem3.school.business.GetCuisineUseCase;
import fontys.sem3.school.business.GetCuisinesUseCase;
import fontys.sem3.school.domain.Cuisine;
import fontys.sem3.school.domain.GetCuisinesResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cuisines")
@AllArgsConstructor
public class CuisinesController {
    private final GetCuisinesUseCase getCuisinesUseCase;
    private final GetCuisineUseCase getCuisineUseCase;
    private final DeleteCuisineUseCase deleteCuisineUseCase;

    @GetMapping
    public ResponseEntity<GetCuisinesResponse> getCuisines() {
        return ResponseEntity.ok(getCuisinesUseCase.getCuisines());
    }
    @GetMapping("{id}")
    public ResponseEntity<Cuisine> getCuisine(@PathVariable(value = "id") final long cuisineId) {
        final Optional<Cuisine> cuisineOptional = getCuisineUseCase.getCuisine(cuisineId);
        if (cuisineOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cuisineOptional.get());
    }
    @DeleteMapping("{cuisineId}")
    public ResponseEntity<Void> deleteCountry(@PathVariable int cuisineId) {
        deleteCuisineUseCase.deleteCuisine(cuisineId);
        return ResponseEntity.noContent().build();
    }

}
