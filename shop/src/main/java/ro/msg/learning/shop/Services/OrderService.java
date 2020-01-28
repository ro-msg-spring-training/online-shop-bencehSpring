package ro.msg.learning.shop.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Configuration.DeliveryStrategyInterface;
import ro.msg.learning.shop.DTO.AddressDTO;
import ro.msg.learning.shop.DTO.OrderDTO;
import ro.msg.learning.shop.DTO.OrderDetailDTO;
import ro.msg.learning.shop.DTO.StockDTO;
import ro.msg.learning.shop.Entities.Address;
import ro.msg.learning.shop.Entities.Location;
import ro.msg.learning.shop.Entities.Order;
import ro.msg.learning.shop.Exceptions.OrderNotFoundException;
import ro.msg.learning.shop.Mapper.OrderDetailMapper;
import ro.msg.learning.shop.Mapper.OrderMapper;
import ro.msg.learning.shop.Repositories.AddressRepository;
import ro.msg.learning.shop.Repositories.LocationRepository;
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
    private final LocationRepository locationRepository;
    private final DeliveryStrategyInterface deliveryStrategyInterface;
    private final StockService stockService;

    public OrderDTO getOrderById(Integer id) throws OrderNotFoundException {
        Optional<Order> orderOptional = orderRepository.findById(id);

        if (orderOptional.isPresent()) {
            return orderMapper.mapOrderToOrderDTO(orderOptional.get());
        } else throw new OrderNotFoundException("This order doesn't exist");
    }

    public OrderDTO createOrder(AddressDTO addressDTO, List<OrderDetailDTO> productsList) {

        List<StockDTO> orderedProducts = deliveryStrategyInterface.doAlgorithm(productsList);

        Order order = Order.builder()
                .deliveryLocation(this.testLocationExistence("ADRESA LUI ", addressDTO))
                .createdAt(LocalDateTime.now())
                .orderDetail(orderDetailMapper.mapOrderDetailListDtoToOrderDetailList(productsList))
                .build();

        order.getOrderDetail().forEach(orderDetail -> orderDetail.setOrder(order));

        orderRepository.save(order);
        orderedProducts.forEach(
                orderedProduct ->
                        stockService.updateStock(orderedProduct.getProductID(), orderedProduct.getLocationID(), orderedProduct.getQuantity())
        );
        return orderMapper.mapOrderToOrderDTO(order);
    }

    public Address testAddressExistence(String country, String city, String street) {
        Optional<Address> addressOptional = addressRepository.findByCountryAndAndCityAndStreet(country, city, street);

        Address address = null;

        if (addressOptional.isPresent()) {
            address = addressOptional.get();
        } else {
            address = new Address();
            address.setCountry(country);
            address.setCity(city);
            address.setStreet(street);
            addressRepository.save(address);
        }

        return address;
    }

    public Location testLocationExistence(String name, AddressDTO addressDTO) {
        Optional<Location> locationOptional = locationRepository.findByAddress_CountryAndAddress_CityAndAddress_Street
                (addressDTO.getAddressCountry(), addressDTO.getAddressCity(), addressDTO.getAddressStreet());

        Location location = null;

        if (locationOptional.isPresent()) {
            location = locationOptional.get();
        } else {
            location = new Location();
            location.setName(name);
            location.setAddress(this.testAddressExistence(addressDTO.getAddressCountry(), addressDTO.getAddressCity(), addressDTO.getAddressStreet()));
            locationRepository.save(location);
        }

        return location;
    }

    public List<OrderDTO> getOrders() {

        List<OrderDTO> orderDTOS = new ArrayList<>();

        for (Order order : orderRepository.findAll())
            orderDTOS.add(orderMapper.mapOrderToOrderDTO(order));

        return orderDTOS;
    }
}
