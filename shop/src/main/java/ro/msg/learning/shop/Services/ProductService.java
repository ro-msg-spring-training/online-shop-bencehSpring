package ro.msg.learning.shop.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.DTO.ProductDTO;
import ro.msg.learning.shop.Entities.Product;
import ro.msg.learning.shop.Entities.ProductCategory;
import ro.msg.learning.shop.Exceptions.ProductNotFoundException;
import ro.msg.learning.shop.Mapper.ProductMapper;
import ro.msg.learning.shop.Repositories.ProductCategoryRepository;
import ro.msg.learning.shop.Repositories.ProductRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategory testCategoryExistence(String categoryName, String categoryDescription) {
        Optional<ProductCategory> productCategory = productCategoryRepository.findByName(categoryName);

        ProductCategory prod = null;

        if (productCategory.isPresent()) {
            prod = productCategory.get();
        } else {
            prod = new ProductCategory();
            prod.setName(categoryName);
            prod.setDescription(categoryDescription);
            productCategoryRepository.save(prod);
        }

        return prod;
    }

    public ProductDTO createProduct(String name, BigDecimal price, Double weight, String description, String image, String categoryName, String categoryDescription) {

        Product product = Product.builder().name(name)
                .description(description)
                .price(price)
                .weight(weight)
                .image(image)
                .productCategory(this.testCategoryExistence(categoryName, categoryDescription))
                .build();
        productRepository.save(product);

        return productMapper.mapProductToProductDto(product);
    }

    public ProductDTO updateProduct(Integer id, String name, BigDecimal price, Double weight, String description, String image, String categoryName, String categoryDescription) {

        if (productRepository.findById(id).isPresent()) {

            Product existingProduct = productRepository.findById(id).get();

            existingProduct.setName(name);
            existingProduct.setPrice(price);
            existingProduct.setWeight(weight);
            existingProduct.setDescription(description);
            existingProduct.setImage(image);
            existingProduct.setProductCategory(this.testCategoryExistence(categoryName,categoryDescription));

            Product updatedProduct = productRepository.save(existingProduct);

            return productMapper.mapProductToProductDto(updatedProduct);
        } else throw new ProductNotFoundException("This product doesn't exist");
    }

    public void deleteProductById(Integer productId) throws ProductNotFoundException {
        productRepository.deleteById(productId);
    }

    public ProductDTO getProductById(Integer id) throws ProductNotFoundException {
        Optional<Product> productOptional = productRepository.findById(id);

        if (productOptional.isPresent()) {
            return productMapper.mapProductToProductDto(productOptional.get());
        } else throw new ProductNotFoundException("This product doesn't exist");
    }

    public List<ProductDTO> getProducts() {

        List<ProductDTO> productList = new ArrayList<>();

        for (Product p : productRepository.findAll()) {
            productList.add(productMapper.mapProductToProductDto(p));
        }
        return productList;
    }
}
