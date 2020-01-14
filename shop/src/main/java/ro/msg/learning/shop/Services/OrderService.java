package ro.msg.learning.shop.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTO.OrderDTO;
import ro.msg.learning.shop.Entities.Orders;
import ro.msg.learning.shop.Exceptions.OrderNotFoundException;
import ro.msg.learning.shop.Mapper.OrderMapper;
import ro.msg.learning.shop.Repositories.OrderRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDTO getOrderById(Integer id) throws OrderNotFoundException {
        Optional<Orders> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            return orderMapper.mapOrderToOrderDTO(orderOptional.get());
        } else throw new OrderNotFoundException("This order doesn't exist");
    }

}
