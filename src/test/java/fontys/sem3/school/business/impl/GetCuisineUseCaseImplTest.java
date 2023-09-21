package fontys.sem3.school.business.impl;

import fontys.sem3.school.domain.Cuisine;
import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCuisineUseCaseImplTest {

    @Mock
    private CuisineRepository cuisineRepositoryMock;
    @InjectMocks
    private GetCuisineUseCaseImpl getCuisineUseCase;
    @Test
    void getCuisine() {
        CuisineEntity dutchEntity = CuisineEntity.builder().id(1).cuisineName("Dutch").build();

            when(cuisineRepositoryMock.findById(1)) .thenReturn(dutchEntity);
        Optional<Cuisine> actualResult = getCuisineUseCase.getCuisine(1);
        Optional<Cuisine> dutch = Optional.ofNullable(Cuisine.builder().id(1L).cuisineName("Dutch").build());

        Optional<Cuisine> expectedResult = dutch;
        assertEquals(expectedResult, actualResult);
        verify(cuisineRepositoryMock).findById(1);
    }

}