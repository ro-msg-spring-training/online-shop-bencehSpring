package ro.msg.learning.shop.mappers;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.entities.Product;
import ro.msg.learning.shop.dtos.ProductDTO;

@Component
public class ProductMapper {

    public ProductDTO mapProductToProductDto(Product product) {
        return ProductDTO.builder()
                .productName(product.getName())
                .id(product.getProductId())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryDescription(product.getProductCategory().getDescription())
                .categoryName(product.getProductCategory().getName())
                .weight(product.getWeight())
                .image(product.getImage())
                .build();
    }
}
