package ro.msg.learning.shop.Mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTO.OrderDTO;
import ro.msg.learning.shop.Entities.Order;

@Component
@RequiredArgsConstructor
public class OrderMapper {

    private final OrderDetailMapper orderDetailMapper;
    private final LocationMapper locationMapper;
    private final AddressMapper addressMapper;

    public OrderDTO mapOrderToOrderDTO(Order order) {
        return OrderDTO.builder()
                .deliveryLocation(addressMapper.mapAddressToAddressDTO(order.getDeliveryLocation().getAddress()))
                .orderTimestamp(order.getCreatedAt())
                .productsList(orderDetailMapper.mapOrderDetailListToOrderDetailDtoList(order.getOrderDetail()))
                .build();
    }

}
