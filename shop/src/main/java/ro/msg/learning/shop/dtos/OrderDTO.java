package ro.msg.learning.shop.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderDTO implements Serializable {

    private Integer id;
    private Integer userId;
    private LocalDateTime orderTimestamp;
    private AddressDTO deliveryLocation;
    private List<OrderDetailDTO> productsList;
}
