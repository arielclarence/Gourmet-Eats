package fontys.sem3.school.business.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import fontys.sem3.school.business.exception.IdAlreadyExistsException;
import fontys.sem3.school.domain.CreateCuisineRequest;
import fontys.sem3.school.domain.CreateCuisineResponse;
import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
class CreateCuisineUseCaseImplTest {

    @Mock
    private CuisineRepository mockCuisineRepository;

    private CreateCuisineUseCaseImpl createCuisineUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        createCuisineUseCase = new CreateCuisineUseCaseImpl(mockCuisineRepository);
    }

    @Test
    void testCreateCuisineSuccess() {
        // Arrange
        CreateCuisineRequest request = new CreateCuisineRequest(1L, "Some Cuisine");
        CuisineEntity savedCuisineEntity = CuisineEntity.builder()
                .id(1L)
                .cuisineName("Some Cuisine")
                .build();

        when(mockCuisineRepository.existsById(1L)).thenReturn(false);
        when(mockCuisineRepository.save(any(CuisineEntity.class))).thenReturn(savedCuisineEntity);

        // Act
        CreateCuisineResponse response = createCuisineUseCase.createCuisine(request);

        // Assert
        assertNotNull(response);
        assertEquals(1L, response.getId());
    }



}