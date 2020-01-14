package ro.msg.learning.shop.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.DTO.ProductDTO;
import ro.msg.learning.shop.Services.ProductService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getAllProducts() {
        return productService.getProducts();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO newProduct(@RequestBody ProductDTO productDTO) {

        return productService
                .createProduct(productDTO.getProductName(), productDTO.getPrice(), productDTO.getWeight(), productDTO.getDescription(),
                        productDTO.getImage(), productDTO.getCategoryName(), productDTO.getCategoryDescription());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO oneProduct(@PathVariable Integer id) {

        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable Integer id) {
        productService.deleteProductById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO, @PathVariable Integer id) {
        return productService.updateProduct(id, productDTO.getProductName(), productDTO.getPrice(),
                productDTO.getWeight(), productDTO.getDescription(), productDTO.getImage(), productDTO.getCategoryName(), productDTO.getCategoryDescription());
    }

}
