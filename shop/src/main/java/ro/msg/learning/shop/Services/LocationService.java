package ro.msg.learning.shop.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTO.LocationDTO;
import ro.msg.learning.shop.Entities.Address;
import ro.msg.learning.shop.Entities.Location;
import ro.msg.learning.shop.Exceptions.LocationNotFoundException;
import ro.msg.learning.shop.Mapper.LocationMapper;
import ro.msg.learning.shop.Repositories.LocationRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationDTO createLocation(String name, String country, String city, String street) {

        Address address = this.addressBuilder(country, city, street);

        Location location = Location.builder()
                .name(name)
                .address(address)
                .build();

        locationRepository.save(location);

        return locationMapper.mapLocationToLocationDTO(location);
    }

    public void deleteLocationById(Integer id) {

        locationRepository.deleteById(id);
    }

    public LocationDTO updateLocationById(Integer id, String name, String country, String city, String street) {
        Optional<Location> locationOptional = locationRepository.findById(id);
        if (locationOptional.isPresent()) {

            Address address = this.addressBuilder(country, city, street);

            Location currentLocation = locationOptional.get();

            currentLocation.setName(name);
            currentLocation.setAddress(address);

            return locationMapper.mapLocationToLocationDTO(currentLocation);
        } else {
            throw new LocationNotFoundException("Location: " + name + "doesn't exist");
        }
    }

    public Address addressBuilder(String country, String city, String street) {
        return Address.builder()
                .country(country)
                .city(city)
                .street(street)
                .build();
    }
}
