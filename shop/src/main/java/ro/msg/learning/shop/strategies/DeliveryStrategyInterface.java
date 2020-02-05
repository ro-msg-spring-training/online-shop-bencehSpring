package ro.msg.learning.shop.strategies;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.OrderDetailDTO;
import ro.msg.learning.shop.dtos.StockDTO;

import java.util.List;

@Component
public interface DeliveryStrategyInterface {

    List<StockDTO> doAlgorithm(List<OrderDetailDTO> orderDetailDTOList);
}
