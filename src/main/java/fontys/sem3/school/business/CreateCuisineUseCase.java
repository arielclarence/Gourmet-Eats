package fontys.sem3.school.business;

import fontys.sem3.school.domain.CreateCuisineRequest;
import fontys.sem3.school.domain.CreateCuisineResponse;

public interface CreateCuisineUseCase {
    CreateCuisineResponse createCuisine(CreateCuisineRequest request);
}
