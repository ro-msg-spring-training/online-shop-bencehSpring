package ro.msg.learning.shop.Configuration;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTO.OrderDetailDTO;
import ro.msg.learning.shop.DTO.StockDTO;

import java.util.List;

@Component
public interface DeliveryStrategyInterface {

    List<StockDTO> doAlgorithm(List<OrderDetailDTO> orderDetailDTOList);
}
