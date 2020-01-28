package ro.msg.learning.shop.Mapper;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTO.StockDTO;
import ro.msg.learning.shop.Entities.Stock;

@Component
public class StockMapper {


    public StockDTO mapStockToStockDTO(Stock stock) {
        return StockDTO.builder()
                .quantity(stock.getQuantity())
                .locationID(stock.getLocation().getId())
                .productID(stock.getProduct().getProductId())
                .build();
    }

}
