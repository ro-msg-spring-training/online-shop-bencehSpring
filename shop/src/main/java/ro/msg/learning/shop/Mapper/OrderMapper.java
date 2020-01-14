package ro.msg.learning.shop.Mapper;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTO.OrderDTO;
import ro.msg.learning.shop.DTO.OrderDetailDTO;
import ro.msg.learning.shop.Entities.Orders;

import java.util.LinkedList;
import java.util.List;

@Component
public class OrderMapper {


    public OrderDTO mapOrderToOrderDTO(Orders order) {

        List<OrderDetailDTO> list = new LinkedList<>();


        list.add(new OrderDetailDTO(order.getOrderDetail().getOrders().getOrderDetail().getId(),order.getOrderDetail().getOrders().getOrderDetail().getQuantity()));

        return OrderDTO.builder()
                .deliveryAddress(order.getOrderDetail().getOrders().getDelivery())
                .orderTimestamp(order.getOrderDetail().getOrders().getCreatedAt())
                .productsList(list)
                .build();
    }
}
