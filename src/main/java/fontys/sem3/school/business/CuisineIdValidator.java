package fontys.sem3.school.business;

import fontys.sem3.school.business.exception.InvalidCuisineException;

public interface CuisineIdValidator {
    void validateId(Long cuisineID) throws InvalidCuisineException;
}
