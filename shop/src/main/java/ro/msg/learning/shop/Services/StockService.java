package ro.msg.learning.shop.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTO.StockDTO;
import ro.msg.learning.shop.Entities.Stock;
import ro.msg.learning.shop.Exceptions.ProductNotFoundException;
import ro.msg.learning.shop.Exceptions.StockNotFoundException;
import ro.msg.learning.shop.Mapper.StockMapper;
import ro.msg.learning.shop.Repositories.LocationRepository;
import ro.msg.learning.shop.Repositories.ProductRepository;
import ro.msg.learning.shop.Repositories.StockRepository;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final LocationRepository locationRepository;
    private final ProductRepository productRepository;
    private final StockMapper stockMapper;

    public StockDTO createStock(Integer productID, Integer quantity, Integer locationID) {

        if (productRepository.findProductByProductId(productID) != null) {
            Stock stock = Stock.builder()
                    .location(locationRepository.findLocationById(locationID))
                    .quantity(quantity)
                    .product(productRepository.findProductByProductId(productID))
                    .build();

            stockRepository.save(stock);
            return stockMapper.mapStockToStockDTO(stock);
        } else {
            throw new ProductNotFoundException("Product: " + productID + " does't exist");
        }
    }

    public StockDTO updateStock(Integer productID, Integer locationID, Integer quantity) {

        if (stockRepository.findStockByProductProductIdAndLocation_Id(productID, locationID).isPresent()) {

            Stock existingStock = stockRepository.findStockByProductProductIdAndLocation_Id(productID, locationID).get();

            existingStock.setQuantity(existingStock.getQuantity() - quantity);
            stockRepository.save(existingStock);
            return stockMapper.mapStockToStockDTO(existingStock);
        } else {
            throw new StockNotFoundException("Stock not found");
        }
    }
}
