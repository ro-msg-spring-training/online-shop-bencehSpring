package ro.msg.learning.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.msg.learning.shop.entities.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
    void deleteCartByProductIdAndUser_Username(Integer id, String username);
    void deleteCartByUser_Username(String username);
}
