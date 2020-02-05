package ro.msg.learning.shop.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.entities.Location;

import java.util.Optional;

public interface LocationRepository extends JpaRepository<Location, Integer> {

    Optional<Location> findByAddress_CountryAndAddress_CityAndAddress_Street(String country, String city, String street);

    Location findLocationById(Integer id);
}
