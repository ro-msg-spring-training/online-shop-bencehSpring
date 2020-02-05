package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.AddressDTO;
import ro.msg.learning.shop.entities.Address;

@Component
@RequiredArgsConstructor
public class AddressMapper {

    public AddressDTO mapAddressToAddressDTO(Address address) {
        return AddressDTO.builder()
                .id(address.getId())
                .addressCountry(address.getCountry())
                .addressCity(address.getCity())
                .addressStreet(address.getStreet())
                .build();
    }
}

