package ro.msg.learning.shop.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.DTO.OrderDTO;
import ro.msg.learning.shop.Services.OrderService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderDTO newOrder(@RequestBody OrderDTO orderDTO) {

        return orderService
                .createOrder(orderDTO.getDeliveryLocation(), orderDTO.getProductsList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OrderDTO oneOrder(@PathVariable Integer id) {

        return orderService.getOrderById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderDTO> getOrders() {
        return orderService.getOrders();
    }
}
