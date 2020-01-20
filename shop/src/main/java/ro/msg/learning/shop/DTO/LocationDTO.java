package ro.msg.learning.shop.DTO;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LocationDTO implements Serializable {

    private String locationName;
    private AddressDTO addressDTO;
}
