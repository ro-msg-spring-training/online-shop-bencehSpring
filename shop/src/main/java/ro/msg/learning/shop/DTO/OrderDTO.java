package ro.msg.learning.shop.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderDTO implements Serializable {

     private LocalDateTime orderTimestamp;

     private AddressDTO deliveryLocation;
     private List<OrderDetailDTO> productsList;
}
