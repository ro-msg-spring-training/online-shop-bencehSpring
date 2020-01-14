package ro.msg.learning.shop.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.msg.learning.shop.Entities.ProductCategory;

import java.util.Optional;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

//    ProductCategory findByName(String name);

    Optional<ProductCategory> findByName(String name);
}
