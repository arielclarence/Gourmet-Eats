package fontys.sem3.school.business.impl;

import fontys.sem3.school.domain.OrderDetail;
import fontys.sem3.school.persistence.entity.OrderDetailEntity;

final class OrderDetailConverter {
    private OrderDetailConverter() {
    }

    public static OrderDetail convert(OrderDetailEntity orderDetailEntity) {
        return OrderDetail.builder()
                .id(orderDetailEntity.getId())
                .orderheaderid(orderDetailEntity.getOrderHeader().getId())
                .foodid(orderDetailEntity.getFood().getId())  // Assuming you have a similar converter for FoodEntity to Food
                .amount(orderDetailEntity.getAmount())
                .subtotal(orderDetailEntity.getSubtotal())
                .specialRequest(orderDetailEntity.getSpecialRequest())
                .build();
    }
}
