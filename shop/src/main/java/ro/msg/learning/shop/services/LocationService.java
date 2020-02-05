package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.dtos.LocationDTO;
import ro.msg.learning.shop.entities.Address;
import ro.msg.learning.shop.entities.Location;
import ro.msg.learning.shop.exceptions.LocationNotFoundException;
import ro.msg.learning.shop.mappers.LocationMapper;
import ro.msg.learning.shop.repositories.LocationRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LocationService {

    private final LocationRepository locationRepository;
    private final LocationMapper locationMapper;

    public LocationDTO createLocation(LocationDTO loc) {
        Address address = this.addressBuilder(loc.getAddressDTO().getAddressCountry(),
                loc.getAddressDTO().getAddressCity(),
                loc.getAddressDTO().getAddressStreet());

        Location location = Location.builder()
                .name(loc.getLocationName())
                .address(address)
                .build();

        locationRepository.save(location);
        return locationMapper.mapLocationToLocationDTO(location);
    }

    public void deleteLocationById(Integer id) {
        locationRepository.deleteById(id);
    }

    public LocationDTO updateLocationById(Integer id, LocationDTO loc) {
        Optional<Location> locationOptional = locationRepository.findById(id);

        if (locationOptional.isPresent()) {
            Address address = this.addressBuilder(loc.getAddressDTO().getAddressCountry(),
                    loc.getAddressDTO().getAddressCity(),
                    loc.getAddressDTO().getAddressStreet());
            Location currentLocation = locationOptional.get();
            currentLocation.setName(loc.getLocationName());
            currentLocation.setAddress(address);
            return locationMapper.mapLocationToLocationDTO(currentLocation);
        } else {
            throw new LocationNotFoundException("Location: " + loc.getLocationName() + "doesn't exist");
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
