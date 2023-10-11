package fontys.sem3.school.controller;

import fontys.sem3.school.business.CreateCuisineUseCase;
import fontys.sem3.school.business.UpdateCuisineUseCase;
import fontys.sem3.school.domain.UpdateCuisineRequest;
import fontys.sem3.school.business.*;
import fontys.sem3.school.domain.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cuisines")
@AllArgsConstructor
public class CuisinesController {
    private final GetCuisinesUseCase getCuisinesUseCase;
    private final GetCuisineUseCase getCuisineUseCase;
    private final DeleteCuisineUseCase deleteCuisineUseCase;
    private final CreateCuisineUseCase createCuisineUseCase;
    private final UpdateCuisineUseCase updateCuisineUseCase;
//b

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
    public ResponseEntity<Void> deleteCuisine(@PathVariable int cuisineId) {
        deleteCuisineUseCase.deleteCuisine(cuisineId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping()
    public ResponseEntity<CreateCuisineResponse> createCuisine(@RequestBody @Valid CreateCuisineRequest request) {
        CreateCuisineResponse response = createCuisineUseCase.createCuisine(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("{id}")
    public ResponseEntity<Void> updateCuisine(@PathVariable("id") long id,
                                              @RequestBody @Valid UpdateCuisineRequest request) {
        request.setId(id);
        updateCuisineUseCase.updateCuisine(request);
        return ResponseEntity.noContent().build();
    }
}
