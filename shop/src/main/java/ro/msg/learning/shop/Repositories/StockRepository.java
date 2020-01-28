package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.Stock;

import java.util.List;
import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Integer> {

    List<Stock> findAllByLocation_Id(Integer id);

    Optional<Stock> findStockByProductProductIdAndLocation_Id(Integer productID, Integer locationID);
}
