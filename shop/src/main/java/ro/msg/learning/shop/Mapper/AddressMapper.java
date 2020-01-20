package ro.msg.learning.shop.Mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.DTO.AddressDTO;
import ro.msg.learning.shop.Entities.Address;

@Component
@RequiredArgsConstructor
public class AddressMapper {

    public AddressDTO mapAddressToAddressDTO(Address address) {
        return AddressDTO.builder()
                .addressCountry(address.getCountry())
                .addressCity(address.getCity())
                .addressStreet(address.getStreet())
                .build();
    }

}

