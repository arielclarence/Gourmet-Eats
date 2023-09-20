package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.DeleteCuisineUseCase;
import fontys.sem3.school.persistence.CuisineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteCuisineUseCaseImpl implements DeleteCuisineUseCase {
    private final CuisineRepository cuisineRepository;

    @Override
    public void deleteCuisine(long cuisineId) {

        this.cuisineRepository.deleteById(cuisineId);
    }
}
