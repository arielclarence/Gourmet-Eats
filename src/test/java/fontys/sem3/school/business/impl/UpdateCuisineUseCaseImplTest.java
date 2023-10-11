package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.CuisineIdValidator;
import fontys.sem3.school.business.exception.InvalidStudentException;
import fontys.sem3.school.domain.UpdateCuisineRequest;
import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class UpdateCuisineUseCaseImplTest {

    @Mock
    private CuisineRepository mockCuisineRepository;

    @Mock
    private CuisineIdValidator mockCuisineIdValidator;

    private UpdateCuisineUseCaseImpl updateCuisineUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        updateCuisineUseCase = new UpdateCuisineUseCaseImpl(mockCuisineRepository, mockCuisineIdValidator);
    }

    @Test
    void testUpdateCuisineSuccess() {
        // Arrange
        Long existingId = 1L;
        UpdateCuisineRequest request = new UpdateCuisineRequest(existingId, "Updated Cuisine");

        CuisineEntity existingCuisineEntity = CuisineEntity.builder()
                .id(existingId)
                .cuisineName("Old Cuisine")
                .build();

        when(mockCuisineRepository.findById(existingId)).thenReturn(existingCuisineEntity);

        // Act
        updateCuisineUseCase.updateCuisine(request);

        // Assert
        verify(mockCuisineIdValidator, times(1)).validateId(existingId);
        assertEquals("Updated Cuisine", existingCuisineEntity.getCuisineName());
    }


}
