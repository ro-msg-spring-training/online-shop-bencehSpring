package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.OrderDTO;
import ro.msg.learning.shop.entities.Order;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderDetailMapper orderDetailMapper;
    private final AddressMapper addressMapper;

    public OrderDTO mapOrderToOrderDTO(Order order) {
        return OrderDTO.builder()
                .deliveryLocation(addressMapper.mapAddressToAddressDTO(order.getDeliveryLocation().getAddress()))
                .orderTimestamp(order.getCreatedAt())
                .userId(order.getUser().getUsername())
                .productsList(orderDetailMapper.mapOrderDetailListToOrderDetailDtoList(order.getOrderDetail()))
                .build();
    }
}
