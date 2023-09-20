package fontys.sem3.school.business.impl;

import fontys.sem3.school.domain.Cuisine;
import fontys.sem3.school.domain.GetCuisinesResponse;
import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetCuisinesUseCaseImplTest {

    @Mock
    private CuisineRepository cuisineRepositoryMock;
    @InjectMocks
    private GetCuisinesUseCaseImpl getCuisinesUseCase;
    @Test
    void getCuisines() {
        CuisineEntity dutchEntity = CuisineEntity.builder().id(1).cuisineName("Dutch").build();
            CuisineEntity turkishEntity = CuisineEntity.builder().id(2).cuisineName("Turkish").build();
            CuisineEntity indonesianEntity = CuisineEntity.builder().id(3).cuisineName("Indonesian").build();
            CuisineEntity chineseEntity = CuisineEntity.builder().id(4).cuisineName("Chinese").build();
            CuisineEntity brazillianEntity = CuisineEntity.builder().id(5).cuisineName("Brazillian").build();
            when(cuisineRepositoryMock.findAll()) .thenReturn(List.of(dutchEntity, turkishEntity,indonesianEntity,chineseEntity,brazillianEntity));
        GetCuisinesResponse actualResult = getCuisinesUseCase.getCuisines();
        Cuisine dutch = Cuisine.builder().id(1L).cuisineName("Dutch").build();
        Cuisine turkish = Cuisine.builder().id(2L).cuisineName("Turkish").build();
        Cuisine indonesian = Cuisine.builder().id(3L).cuisineName("Indonesian").build();
        Cuisine chinese = Cuisine.builder().id(4L).cuisineName("Chinese").build();
        Cuisine brazillian = Cuisine.builder().id(5L).cuisineName("Brazillian").build();
        GetCuisinesResponse expectedResult = GetCuisinesResponse .builder() .countries(List.of(dutch, turkish,indonesian,chinese,brazillian)) .build();
        assertEquals(expectedResult, actualResult);
        verify(cuisineRepositoryMock).findAll();
    }

}