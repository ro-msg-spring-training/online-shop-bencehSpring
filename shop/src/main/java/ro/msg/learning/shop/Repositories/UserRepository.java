package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
