package ro.msg.learning.shop.mappers;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.StockDTO;
import ro.msg.learning.shop.entities.Stock;

@Component
public class StockMapper {

    public StockDTO mapStockToStockDTO(Stock stock) {
        return StockDTO.builder()
                .id(stock.getId())
                .quantity(stock.getQuantity())
                .locationID(stock.getLocation().getId())
                .productID(stock.getProduct().getProductId())
                .build();
    }
}
