package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.CuisineIdValidator;
import fontys.sem3.school.business.exception.InvalidCuisineException;
import fontys.sem3.school.persistence.CuisineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CuisineIdValidatorImpl implements CuisineIdValidator {
    private final CuisineRepository cuisineRepository;

    @Override
    public void validateId(Long cuisineId) {
        if (cuisineId == null || !cuisineRepository.existsById(cuisineId)) {
            throw new InvalidCuisineException();
        }
    }
}
