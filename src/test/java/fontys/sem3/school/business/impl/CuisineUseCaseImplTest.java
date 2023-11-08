package fontys.sem3.school.business.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import fontys.sem3.school.business.CuisineIdValidator;
import fontys.sem3.school.domain.*;
import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;
//@SpringBootTest
class CuisineUseCaseImplTest {

    @Mock
    private CuisineRepository mockcuisineRepository;

    private CuisineUseCaseImpl cuisineUseCase;
    @Mock
    private  CuisineIdValidator cuisineIdValidator;




    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        cuisineUseCase = new CuisineUseCaseImpl(mockcuisineRepository,cuisineIdValidator);
    }

    @Test
    void testCreateCuisineSuccess() {
        // Arrange
        CreateCuisineRequest request = new CreateCuisineRequest(1L, "Some Cuisine");
        CuisineEntity savedCuisineEntity = CuisineEntity.builder()
                .id(1L)
                .name("Some Cuisine")
                .build();

        when(mockcuisineRepository.existsById(1L)).thenReturn(false);
        when(mockcuisineRepository.save(any(CuisineEntity.class))).thenReturn(savedCuisineEntity);

        // Act
        CreateCuisineResponse response = cuisineUseCase.createCuisine(request);

        // Assert
        assertNotNull(response);
        assertEquals(1L, response.getId());
    }
    @Test
    void deleteCuisine() {
        // Arrange
        CuisineRepository cuisineRepositoryMock = Mockito.mock(CuisineRepository.class);

        // Create an instance of DeleteCuisineUseCaseImpl with the mock repository
        CuisineUseCaseImpl deleteCuisineUseCase = new CuisineUseCaseImpl(cuisineRepositoryMock,cuisineIdValidator);

        // Set up a test cuisine ID
        long cuisineId = 1L;

        // Call the deleteCuisine method
        deleteCuisineUseCase.deleteCuisine(cuisineId);

        // Verify that deleteById was called with the correct cuisineId
        Mockito.verify(cuisineRepositoryMock, Mockito.times(1)).deleteById(cuisineId);

        // Assertas
    }
    @Test
    void getCuisines() {
        CuisineEntity dutchEntity = CuisineEntity.builder().id(1).name("Dutch").build();
        CuisineEntity turkishEntity = CuisineEntity.builder().id(2).name("Turkish").build();
        CuisineEntity indonesianEntity = CuisineEntity.builder().id(3).name("Indonesian").build();
        CuisineEntity chineseEntity = CuisineEntity.builder().id(4).name("Chinese").build();
        CuisineEntity brazillianEntity = CuisineEntity.builder().id(5).name("Brazillian").build();
        when(mockcuisineRepository.findAll()) .thenReturn(List.of(dutchEntity, turkishEntity,indonesianEntity,chineseEntity,brazillianEntity));
        GetCuisinesResponse actualResult = cuisineUseCase.getCuisines();
        Cuisine dutch = Cuisine.builder().id(1L).cuisineName("Dutch").build();
        Cuisine turkish = Cuisine.builder().id(2L).cuisineName("Turkish").build();
        Cuisine indonesian = Cuisine.builder().id(3L).cuisineName("Indonesian").build();
        Cuisine chinese = Cuisine.builder().id(4L).cuisineName("Chinese").build();
        Cuisine brazillian = Cuisine.builder().id(5L).cuisineName("Brazillian").build();
        GetCuisinesResponse expectedResult = GetCuisinesResponse .builder() .cuisines(List.of(dutch, turkish,indonesian,chinese,brazillian)) .build();
        assertEquals(expectedResult, actualResult);
        verify(mockcuisineRepository).findAll();
    }
    @Test
    void getCuisine() {
        CuisineEntity dutchEntity = CuisineEntity.builder().id(1).name("Dutch").build();

        when(mockcuisineRepository.findById(1L)) .thenReturn(Optional.ofNullable(dutchEntity));
        Optional<Cuisine> actualResult = cuisineUseCase.getCuisine(1);
        Optional<Cuisine> dutch = Optional.ofNullable(Cuisine.builder().id(1L).cuisineName("Dutch").build());

        Optional<Cuisine> expectedResult = dutch;
        assertEquals(expectedResult, actualResult);
        verify(mockcuisineRepository).findById(1L);
    }

    @Test
    void testUpdateCuisineSuccess() {
        // Arrange
        Long existingId = 1L;
        UpdateCuisineRequest request = new UpdateCuisineRequest(existingId, "Updated Cuisine");

        CuisineEntity existingCuisineEntity = CuisineEntity.builder()
                .id(existingId)
                .name("Old Cuisine")
                .build();

        when(mockcuisineRepository.findById(existingId)).thenReturn(Optional.ofNullable(existingCuisineEntity));

        // Act
        cuisineUseCase.updateCuisine(request);

        // Assert
        verify(cuisineIdValidator, times(1)).validateId(existingId);
        assertEquals("Updated Cuisine", existingCuisineEntity.getName());
    }




}