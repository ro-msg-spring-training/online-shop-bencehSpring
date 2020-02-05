package ro.msg.learning.shop.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ProductDTO implements Serializable {

    private Integer id;
    private String productName;
    private BigDecimal price;
    private Double weight;
    private String description;
    private String image;
    private String categoryName;
    private String categoryDescription;
}
