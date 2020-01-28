package ro.msg.learning.shop.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import ro.msg.learning.shop.DTO.OrderDetailDTO;
import ro.msg.learning.shop.DTO.StockDTO;
import ro.msg.learning.shop.Entities.Location;
import ro.msg.learning.shop.Entities.Stock;
import ro.msg.learning.shop.Exceptions.ProductsNotAvailableException;
import ro.msg.learning.shop.Repositories.LocationRepository;
import ro.msg.learning.shop.Repositories.StockRepository;

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
                    if (currentStock.getProduct().getProductId().equals(requestedStock.getProductID()) && requestedStock.getQuantity() < currentStock.getQuantity()) {
                        stockList.add(
                                StockDTO.builder()
                                        .productID(requestedStock.getProductID())
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
