package ro.msg.learning.shop.DTO;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class AddressDTO implements Serializable {
    private String addressCountry;
    private String addressCity;
    private String addressStreet;
}
