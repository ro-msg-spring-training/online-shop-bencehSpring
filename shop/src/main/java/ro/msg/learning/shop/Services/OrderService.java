package ro.msg.learning.shop.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTO.AddressDTO;
import ro.msg.learning.shop.DTO.LocationDTO;
import ro.msg.learning.shop.DTO.OrderDTO;
import ro.msg.learning.shop.DTO.OrderDetailDTO;
import ro.msg.learning.shop.Entities.Address;
import ro.msg.learning.shop.Entities.Location;
import ro.msg.learning.shop.Entities.Order;
import ro.msg.learning.shop.Exceptions.OrderNotFoundException;
import ro.msg.learning.shop.Mapper.OrderDetailMapper;
import ro.msg.learning.shop.Mapper.OrderMapper;
import ro.msg.learning.shop.Repositories.AddressRepository;
import ro.msg.learning.shop.Repositories.OrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderDetailMapper orderDetailMapper;
    private final AddressRepository addressRepository;

    public OrderDTO getOrderById(Integer id) throws OrderNotFoundException {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            return orderMapper.mapOrderToOrderDTO(orderOptional.get());
        } else throw new OrderNotFoundException("This order doesn't exist");
    }

    public OrderDTO createOrder(AddressDTO addressDTO, List<OrderDetailDTO> productsList) {
        Address address = Address.builder()
                .country(addressDTO.getAddressCountry())
                .city(addressDTO.getAddressCity())
                .street(addressDTO.getAddressStreet())
                .build();

        Location location = Location.builder()
                .name("Mama")
                .address(address)
                .build();

        Order order = Order.builder()
                .deliveryLocation(location)
                .createdAt(LocalDateTime.now())
                .orderDetail(orderDetailMapper.mapOrderDetailListDtoToOrderDetailList(productsList))
                .build();

        order.getOrderDetail().forEach(orderDetail -> orderDetail.setOrder(order));
        
        orderRepository.save(order);

        return orderMapper.mapOrderToOrderDTO(order);
    }

    public List<OrderDTO> getOrders() {

        List<OrderDTO> orderDTOS = new ArrayList<>();

        for (Order order : orderRepository.findAll())
            orderDTOS.add(orderMapper.mapOrderToOrderDTO(order));

        return orderDTOS;
    }
}
