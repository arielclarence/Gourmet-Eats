package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.CuisineUseCase;
import fontys.sem3.school.business.CuisineIdValidator;
import fontys.sem3.school.business.exception.IdAlreadyExistsException;
import fontys.sem3.school.business.exception.InvalidUserException;
import fontys.sem3.school.domain.*;
import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CuisineUseCaseImpl implements CuisineUseCase {
    private final CuisineRepository cuisineRepository;
    private final CuisineIdValidator cuisineIdValidator;
    @Override
    public void deleteCuisine(long cuisineId) {

        this.cuisineRepository.deleteById(cuisineId);
    }
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
    @Override
    public CreateCuisineResponse createCuisine(CreateCuisineRequest request) {
//        if (cuisineRepository.existsById(request.getId())) {
//            throw new IdAlreadyExistsException();
//        }
        CuisineEntity savedCuisine = saveNewCuisine(request);

        return CreateCuisineResponse.builder()
                .id(savedCuisine.getId())
                .build();
    }
    @Override
    public Optional<Cuisine> getCuisine(long cuisineId) {
        return cuisineRepository.findById(cuisineId).map(CuisineConverter::convert);

    }
    private CuisineEntity saveNewCuisine(CreateCuisineRequest request) {


        CuisineEntity newCuisine = CuisineEntity.builder()
                .name(request.getName())
                .build();
        return cuisineRepository.save(newCuisine);
    }
    @Override
    public void updateCuisine(UpdateCuisineRequest request) {
        Optional<CuisineEntity> CuisineOptional = cuisineRepository.findById(request.getId());
        if (CuisineOptional.isEmpty()) {
            throw new InvalidUserException("CUISINE_ID_INVALID");
        }

        cuisineIdValidator.validateId(request.getId());

        CuisineEntity Cuisine = CuisineOptional.get();
        updateFields(request, Cuisine);
    }

    private void updateFields(UpdateCuisineRequest request, CuisineEntity Cuisine) {
        Cuisine.setName(request.getName());
        Cuisine.setId(request.getId());
        cuisineRepository.save(Cuisine);
    }
}
