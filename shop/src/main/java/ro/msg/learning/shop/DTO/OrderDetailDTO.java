package ro.msg.learning.shop.DTO;

import lombok.*;

import java.io.Serializable;

@Data
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderDetailDTO implements Serializable {

    private Integer productID;
    private Integer quantity;
}
