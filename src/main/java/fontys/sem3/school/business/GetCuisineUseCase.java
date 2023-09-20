package fontys.sem3.school.business;

import fontys.sem3.school.domain.Cuisine;

import java.util.Optional;

public interface GetCuisineUseCase {

    Optional<Cuisine> getCuisine(long cuisineid);
}
