package ro.msg.learning.shop.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.Location;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    Optional<Location> findByAddress_CountryAndAddress_CityAndAddress_Street(String country, String city, String street);
}
