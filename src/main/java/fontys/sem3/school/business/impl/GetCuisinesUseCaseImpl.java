package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.GetCuisinesUseCase;
import fontys.sem3.school.domain.Cuisine;
import fontys.sem3.school.domain.GetCuisinesResponse;
import fontys.sem3.school.persistence.CuisineRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class GetCuisinesUseCaseImpl implements GetCuisinesUseCase {
    private final CuisineRepository cuisineRepository;

    @Override
    public GetCuisinesResponse getCuisines() {
        List<Cuisine> cuisines = cuisineRepository.findAll()
                .stream()
                .map(CuisineConverter::convert)
                .toList();

        return GetCuisinesResponse.builder()
                .cuisines(cuisines)
                .build();
    }
}
