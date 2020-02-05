package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dtos.StockDTO;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.exceptions.ProductNotFoundException;
import ro.msg.learning.shop.exceptions.StockNotFoundException;
import ro.msg.learning.shop.mappers.StockMapper;
import ro.msg.learning.shop.repositories.LocationRepository;
import ro.msg.learning.shop.repositories.ProductRepository;
import ro.msg.learning.shop.repositories.StockRepository;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository stockRepository;
    private final LocationRepository locationRepository;
    private final ProductRepository productRepository;
    private final StockMapper stockMapper;

    public StockDTO createStock(StockDTO stockDTO) {
        if (productRepository.findProductByProductId(stockDTO.getProductID()) != null) {
            Stock stock = Stock.builder()
                    .location(locationRepository.findLocationById(stockDTO.getLocationID()))
                    .quantity(stockDTO.getQuantity())
                    .product(productRepository.findProductByProductId(stockDTO.getProductID()))
                    .build();

            stockRepository.save(stock);
            return stockMapper.mapStockToStockDTO(stock);
        } else {
            throw new ProductNotFoundException("Product: " + stockDTO.getProductID() + " does't exist");
        }
    }

    public StockDTO updateStock(StockDTO stockDTO) {
        if (stockRepository.findStockByProductProductIdAndLocation_Id(stockDTO.getProductID(), stockDTO.getLocationID()).isPresent()) {
            Stock existingStock = stockRepository.findStockByProductProductIdAndLocation_Id(stockDTO.getProductID(), stockDTO.getLocationID()).get();
            existingStock.setQuantity(existingStock.getQuantity() - stockDTO.getQuantity());
            stockRepository.save(existingStock);
            return stockMapper.mapStockToStockDTO(existingStock);
        } else {
            throw new StockNotFoundException("Stock not found");
        }
    }
}
