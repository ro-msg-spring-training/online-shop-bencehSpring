package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.Order;

public interface OrderRepository extends JpaRepository<Order,Integer> {
}
