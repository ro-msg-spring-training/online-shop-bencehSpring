package ro.msg.learning.shop.DTO;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class ProductDTO implements Serializable {

    private String productName;
    private BigDecimal price;
    private Double weight;
    private String description;
    private String image;
    private String categoryName;
    private String categoryDescription;
}
