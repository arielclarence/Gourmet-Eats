package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.CuisineIdValidator;
import fontys.sem3.school.business.UpdateCuisineUseCase;
import fontys.sem3.school.business.exception.InvalidStudentException;
import fontys.sem3.school.domain.UpdateCuisineRequest;
import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UpdateCuisineUseCaseImpl implements UpdateCuisineUseCase {
    private final CuisineRepository CuisineRepository;
    private final CuisineIdValidator CuisineIdValidator;

    @Override
    public void updateCuisine(UpdateCuisineRequest request) {
        Optional<CuisineEntity> CuisineOptional = Optional.ofNullable(CuisineRepository.findById(request.getId()));
        if (CuisineOptional.isEmpty()) {
            throw new InvalidStudentException("Cuisine_ID_INVALID");
        }

        CuisineIdValidator.validateId(request.getId());

        CuisineEntity Cuisine = CuisineOptional.get();
        updateFields(request, Cuisine);
    }

    private void updateFields(UpdateCuisineRequest request, CuisineEntity Cuisine) {
        Cuisine.setCuisineName(request.getCuisinename());
        Cuisine.setId(request.getId());

//        CuisineRepository.save(Cuisine);
    }
}
