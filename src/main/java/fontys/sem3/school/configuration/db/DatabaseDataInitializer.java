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
            cuisineRepository.save(CuisineEntity.builder().cuisineName("Dutch").build());
            cuisineRepository.save(CuisineEntity.builder().cuisineName("Turkish").build());
            cuisineRepository.save(CuisineEntity.builder().cuisineName("Indonesian").build());
            cuisineRepository.save(CuisineEntity.builder().cuisineName("Chinese").build());
            cuisineRepository.save(CuisineEntity.builder().cuisineName("Brazillian").build());
        }

    }
}
