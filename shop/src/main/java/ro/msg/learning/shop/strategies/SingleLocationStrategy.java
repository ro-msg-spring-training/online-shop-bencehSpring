package ro.msg.learning.shop.strategies;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.dtos.OrderDetailDTO;
import ro.msg.learning.shop.dtos.StockDTO;
import ro.msg.learning.shop.entities.Location;
import ro.msg.learning.shop.entities.Stock;
import ro.msg.learning.shop.exceptions.ProductsNotAvailableException;
import ro.msg.learning.shop.repositories.LocationRepository;
import ro.msg.learning.shop.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;

public class SingleLocationStrategy implements DeliveryStrategyInterface {

    @Autowired
    private StockRepository stockRepository;
    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<StockDTO> doAlgorithm(List<OrderDetailDTO> requested) {

        List<Location> locationList = locationRepository.findAll();
        List<StockDTO> stockList = new ArrayList<>();

        for (Location location : locationList) {
            List<Stock> locationStock = stockRepository.findAllByLocation_Id(location.getId());

            stockList.clear();

            for (Stock currentStock : locationStock) {
                for (OrderDetailDTO requestedStock : requested) {
                    if (currentStock.getProduct().getProductId().equals(requestedStock.getProductId()) && requestedStock.getQuantity() < currentStock.getQuantity()) {
                        stockList.add(
                                StockDTO.builder()
                                        .productID(requestedStock.getProductId())
                                        .locationID(location.getId())
                                        .quantity(requestedStock.getQuantity())
                                        .build()
                        );
                        if (stockList.size() == requested.size())
                            return stockList;
                    }
                }
            }
        }
        throw new ProductsNotAvailableException("Products: " + requested.toString() + " not available in a single location");
    }
}
