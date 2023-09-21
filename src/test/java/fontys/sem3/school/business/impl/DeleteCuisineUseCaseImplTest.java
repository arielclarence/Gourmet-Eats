package fontys.sem3.school.business.impl;

import fontys.sem3.school.controller.CuisinesController;
import fontys.sem3.school.domain.Cuisine;
import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DeleteCuisineUseCaseImplTest {



    @Mock
    private CuisineRepository cuisineRepositoryMock;
    @InjectMocks
    private DeleteCuisineUseCaseImpl deleteCuisineUseCase;
    @Test
    void deleteCuisine() {
        // Arrange
        CuisineRepository cuisineRepositoryMock = Mockito.mock(CuisineRepository.class);

        // Create an instance of DeleteCuisineUseCaseImpl with the mock repository
        DeleteCuisineUseCaseImpl deleteCuisineUseCase = new DeleteCuisineUseCaseImpl(cuisineRepositoryMock);

        // Set up a test cuisine ID
        long cuisineId = 1L;

        // Call the deleteCuisine method
        deleteCuisineUseCase.deleteCuisine(cuisineId);

        // Verify that deleteById was called with the correct cuisineId
        Mockito.verify(cuisineRepositoryMock, Mockito.times(1)).deleteById(cuisineId);

        // Assertas
    }

}