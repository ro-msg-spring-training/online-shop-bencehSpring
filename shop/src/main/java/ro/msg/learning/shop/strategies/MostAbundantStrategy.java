package ro.msg.learning.shop.strategies;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.dtos.OrderDetailDTO;
import ro.msg.learning.shop.dtos.StockDTO;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.exceptions.ProductsNotAvailableException;
import ro.msg.learning.shop.repositories.StockRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MostAbundantStrategy implements DeliveryStrategyInterface {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public List<StockDTO> doAlgorithm(List<OrderDetailDTO> requested) {

        List<StockDTO> existingProducts = new ArrayList<>();

        for (OrderDetailDTO requestedProducts : requested) {
            List<Stock> stocksWhichContainsTheProduct = stockRepository.findStockByProductProductId(requestedProducts.getProductId());

            Stock mostAbundant = stocksWhichContainsTheProduct.stream().max(Comparator.comparing(Stock::getQuantity)).get();

            if (requestedProducts.getQuantity() < mostAbundant.getQuantity())
                existingProducts.add(StockDTO.builder()
                        .quantity(requestedProducts.getQuantity())
                        .locationID(mostAbundant.getLocation().getId())
                        .productID(requestedProducts.getProductId())
                        .build()
                );
            if (existingProducts.size() == requested.size())
                return existingProducts;
        }
        throw new ProductsNotAvailableException("Products: " + requested.toString() + " not available");
    }
}
