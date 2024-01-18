package fontys.sem3.school.business.impl;

import fontys.sem3.school.domain.OrderHeader;
import fontys.sem3.school.persistence.entity.OrderHeaderEntity;

final class OrderHeaderConverter {
    private OrderHeaderConverter() {
    }

    public static OrderHeader convert(OrderHeaderEntity orderHeaderEntity) {
        return OrderHeader.builder()
                .id(orderHeaderEntity.getId())
                .total(orderHeaderEntity.getTotal())
                .userid(orderHeaderEntity.getUserId())  // Assuming you have a similar converter for UserEntity to User// Assuming you have a similar converter for OrderDetailEntity to OrderDetail
                .build();
    }
}
