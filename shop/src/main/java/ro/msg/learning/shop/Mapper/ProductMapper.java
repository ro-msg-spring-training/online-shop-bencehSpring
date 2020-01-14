package ro.msg.learning.shop.Mapper;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.DTO.ProductDTO;

@Component
public class ProductMapper {

    public ProductDTO mapProductToProductDto(Product product) {
        return ProductDTO.builder()
                .productName(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryDescription(product.getProductCategory().getDescription())
                .categoryName(product.getProductCategory().getName())
                .weight(product.getWeight())
                .image(product.getImage())
                .build();
    }
}
