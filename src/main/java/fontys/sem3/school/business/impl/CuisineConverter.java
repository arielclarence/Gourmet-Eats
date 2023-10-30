package fontys.sem3.school.business.impl;

import fontys.sem3.school.domain.Cuisine;
import fontys.sem3.school.persistence.entity.CuisineEntity;

final class CuisineConverter {
    private CuisineConverter() {
    }

    public static Cuisine convert(CuisineEntity cuisine) {
        return Cuisine.builder()
                .id(cuisine.getId())
                .cuisineName(cuisine.getName())
                .build();
    }
}
