package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.LocationDTO;
import ro.msg.learning.shop.entities.Location;

@Component
@RequiredArgsConstructor
public class LocationMapper {

    private final AddressMapper addressMapper;

    public LocationDTO mapLocationToLocationDTO(Location location) {
        return LocationDTO.builder()
                .id(location.getId())
                .locationName(location.getName())
                .addressDTO(addressMapper.mapAddressToAddressDTO(location.getAddress()))
                .build();
    }
}
