package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {


}
