package fontys.sem3.school.configuration.db;

import fontys.sem3.school.persistence.CuisineRepository;
import fontys.sem3.school.persistence.entity.CuisineEntity;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DatabaseDataInitializer {

    private CuisineRepository cuisineRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void populateDatabaseInitialDummyData() {
        if (cuisineRepository.count() == 0) {
            cuisineRepository.save(CuisineEntity.builder().name("Dutch").build());
            cuisineRepository.save(CuisineEntity.builder().name("Turkish").build());
            cuisineRepository.save(CuisineEntity.builder().name("Indonesian").build());
            cuisineRepository.save(CuisineEntity.builder().name("Chinese").build());
            cuisineRepository.save(CuisineEntity.builder().name("Brazillian").build());
        }

    }
}
