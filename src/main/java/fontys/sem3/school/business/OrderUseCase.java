package fontys.sem3.school.business;

import fontys.sem3.school.domain.*;

public interface OrderUseCase {

    GetAllOrderHeaderResponse getAllOrderHeaders();
    CreateOrderResponse createOrders(CreateOrderRequest request);
    GetAllOrderDetailResponse getOrderDetailsbyOrderHeaderid(long UserId);
}
