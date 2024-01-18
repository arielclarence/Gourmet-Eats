package fontys.sem3.school.business.impl;

import fontys.sem3.school.business.OrderUseCase;
import fontys.sem3.school.domain.*;
import fontys.sem3.school.persistence.FoodRepository;
import fontys.sem3.school.persistence.OrderDetailRepository;
import fontys.sem3.school.persistence.OrderHeaderRepository;
import fontys.sem3.school.persistence.entity.FoodEntity;
import fontys.sem3.school.persistence.entity.OrderDetailEntity;
import fontys.sem3.school.persistence.entity.OrderHeaderEntity;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderUseCaseImpl implements OrderUseCase {

    private final OrderDetailRepository orderDetailRepository;
    private final OrderHeaderRepository orderHeaderRepository;
    private final FoodRepository foodRepository;

    @Override
    public GetAllOrderHeaderResponse getAllOrderHeaders() {

        List<OrderHeader> orders = orderHeaderRepository.findAll()
                .stream()
                .map(OrderHeaderConverter::convert)
                .toList();
        return GetAllOrderHeaderResponse.builder()
                .orderheaders(orders)
                .build();
    }

    @Override
    @Transactional
    public CreateOrderResponse createOrders(CreateOrderRequest request) {
        OrderHeaderEntity orderHeaderEntity = OrderHeaderEntity.builder()
                .userId(request.getUserId())
                .total(request.getTotal())
                .build();
        OrderHeaderEntity savedOrderHeader = orderHeaderRepository.save(orderHeaderEntity);
        long orderHeaderId = savedOrderHeader.getId();

        // Create OrderDetailEntity instances and associate them with the OrderHeader
        List<OrderDetailEntity> orderDetailEntities = request.getOrderItems().stream()
                .map(orderItem -> {
                    Optional<FoodEntity> food = foodRepository.findById((orderItem.getFoodid()));

                    return OrderDetailEntity.builder()
                            .food(food.get())
                            .amount(orderItem.getAmount())
                            .subtotal(orderItem.getSubtotal())
                            .specialRequest(orderItem.getSpecialRequest())
                            .orderHeader(savedOrderHeader)
                            .build();
                })
                .toList();

        // Save OrderDetailEntities
        orderDetailRepository.saveAll(orderDetailEntities);

        // Return a CreateOrderResponse with the necessary information
        return CreateOrderResponse.builder()
                .Id(orderHeaderId)
                .build();
    }

    @Override
    public GetAllOrderDetailResponse getOrderDetailsbyOrderHeaderid(long userId) {
        // Implement logic to fetch orders by user ID
        List<OrderDetail> orderdetails = orderDetailRepository.findByOrderHeader_Id(userId)
                .stream()
                .map(OrderDetailConverter::convert)
                .toList();
        return GetAllOrderDetailResponse.builder()
                .orderdetails(orderdetails).build();
    }



}
