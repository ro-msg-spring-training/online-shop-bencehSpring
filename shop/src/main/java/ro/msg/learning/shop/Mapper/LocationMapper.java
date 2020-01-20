package ro.msg.learning.shop.Mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTO.LocationDTO;
import ro.msg.learning.shop.Entities.Location;

@Component
@RequiredArgsConstructor
public class LocationMapper {

    private final AddressMapper addressMapper;

    public LocationDTO mapLocationToLocationDTO(Location location) {
        return LocationDTO.builder()
                .locationName(location.getName())
                .addressDTO(addressMapper.mapAddressToAddressDTO(location.getAddress()))
                .build();
    }
}
