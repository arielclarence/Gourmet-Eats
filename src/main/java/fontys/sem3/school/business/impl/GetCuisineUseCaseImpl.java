package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.GetCuisineUseCase;

import fontys.sem3.school.domain.Cuisine;
import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class GetCuisineUseCaseImpl implements GetCuisineUseCase {

    private CuisineRepository cuisineRepository;

    @Override
    public Optional<Cuisine> getCuisine(long cuisineId) {
        return Optional.ofNullable(cuisineRepository.findById(cuisineId)).map(CuisineConverter::convert);

    }
}
