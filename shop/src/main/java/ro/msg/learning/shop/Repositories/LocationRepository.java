package ro.msg.learning.shop.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {
}
