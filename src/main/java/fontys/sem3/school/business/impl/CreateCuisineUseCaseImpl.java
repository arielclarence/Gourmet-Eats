package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.CreateCuisineUseCase;
import fontys.sem3.school.business.exception.IdAlreadyExistsException;
import fontys.sem3.school.domain.CreateCuisineRequest;
import fontys.sem3.school.domain.CreateCuisineResponse;
import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateCuisineUseCaseImpl implements CreateCuisineUseCase {
    private final CuisineRepository CuisineRepository;

    @Override
    public CreateCuisineResponse createCuisine(CreateCuisineRequest request) {
        if (CuisineRepository.existsById(request.getId())) {
            throw new IdAlreadyExistsException();
        }



        CuisineEntity savedCuisine = saveNewCuisine(request);

        return CreateCuisineResponse.builder()
                .id(savedCuisine.getId())
                .build();
    }

    private CuisineEntity saveNewCuisine(CreateCuisineRequest request) {


        CuisineEntity newCuisine = CuisineEntity.builder()
                .id(request.getId())
                .cuisineName(request.getCuisinename())
                .build();
        return CuisineRepository.save(newCuisine);
    }
}
