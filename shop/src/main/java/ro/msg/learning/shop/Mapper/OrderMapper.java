package ro.msg.learning.shop.Mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTO.OrderDTO;
import ro.msg.learning.shop.Entities.Orders;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderDetailMapper orderDetailMapper;

    public OrderDTO mapOrderToOrderDTO(Orders order) {
        return OrderDTO.builder().deliveryAddress(order.getDelivery())
                .orderTimestamp(order.getCreatedAt())
                .productsList(orderDetailMapper.mapOrderDetailListToOrderDetailDtoList(order.getOrderDetail()))
                .build();
    }

    public Orders mapOrderDtoToOrder(OrderDTO orderDTO) {

        return Orders.builder().delivery(orderDTO.getDeliveryAddress())
                .createdAt(orderDTO.getOrderTimestamp())
                .orderDetail(orderDetailMapper.mapOrderDetailListDtoToOrderDetailList(orderDTO.getProductsList()))
                .build();
    }

}
