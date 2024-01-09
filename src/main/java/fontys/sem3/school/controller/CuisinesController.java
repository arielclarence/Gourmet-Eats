package fontys.sem3.school.controller;

import fontys.sem3.school.business.CuisineUseCase;
import fontys.sem3.school.domain.UpdateCuisineRequest;
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
@RequestMapping("/cuisine")
@AllArgsConstructor
public class CuisinesController {

    private final CuisineUseCase cuisineUseCase;


    @GetMapping
    @RolesAllowed({"Customer", "Admin","Seller"})
    public ResponseEntity<GetCuisinesResponse> getCuisines() {
        return ResponseEntity.ok(cuisineUseCase.getCuisines());
    }
    @GetMapping("{id}")
    @RolesAllowed({"Customer", "Admin","Seller"})
    public ResponseEntity<Cuisine> getCuisine(@PathVariable(value = "id") final long cuisineId) {
        final Optional<Cuisine> cuisineOptional = cuisineUseCase.getCuisine(cuisineId);
        if (cuisineOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cuisineOptional.get());
    }
    @DeleteMapping("{cuisineId}")
    @RolesAllowed({"Admin"})
    public ResponseEntity<Void> deleteCuisine(@PathVariable int cuisineId) {
        cuisineUseCase.deleteCuisine(cuisineId);
        return ResponseEntity.noContent().build();
    }
    @PostMapping()
    @RolesAllowed({"Admin"})
    public ResponseEntity<CreateCuisineResponse> createCuisine(@RequestBody @Valid CreateCuisineRequest request) {
        CreateCuisineResponse response = cuisineUseCase.createCuisine(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @PutMapping("{id}")
    @RolesAllowed({"Admin"})
    public ResponseEntity<Void> updateCuisine(@PathVariable("id") long id,
                                              @RequestBody @Valid UpdateCuisineRequest request) {
        request.setId(id);
        cuisineUseCase.updateCuisine(request);
        return ResponseEntity.noContent().build();
    }
}
