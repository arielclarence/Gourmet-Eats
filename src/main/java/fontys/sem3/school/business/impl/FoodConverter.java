package fontys.sem3.school.business.impl;

import fontys.sem3.school.domain.Food;
import fontys.sem3.school.domain.User;
import fontys.sem3.school.persistence.entity.FoodEntity;
import fontys.sem3.school.persistence.entity.UserEntity;

final class FoodConverter {
    private FoodConverter() {
    }

    public static Food convert(FoodEntity foode) {
        return Food.builder()
                .id(foode.getId())
                .seller(foode.getSeller())
                .name(foode.getName())
                .code(foode.getCode())
                .description(foode.getDescription())
                .pictureUrl(foode.getPictureUrl())
                .price(foode.getPrice())
                .totalSales(foode.getTotalsales())
                .status(foode.isStatus())
                .cuisine(foode.getCuisine())
                .build();

    }
}
