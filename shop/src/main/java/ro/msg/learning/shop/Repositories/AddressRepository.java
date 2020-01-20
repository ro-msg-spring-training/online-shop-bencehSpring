package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
