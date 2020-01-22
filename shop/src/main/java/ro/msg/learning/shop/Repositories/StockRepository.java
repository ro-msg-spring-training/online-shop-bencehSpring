package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.Stock;

public interface StockRepository extends JpaRepository<Stock, Integer> {
}
