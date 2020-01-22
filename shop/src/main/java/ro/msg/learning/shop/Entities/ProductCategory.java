package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "category")
public class ProductCategory {

    @Id
    @TableGenerator(name = "mySeqGen", initialValue = 50, allocationSize = 100)
    @GeneratedValue(generator = "mySeqGen")
    private Integer productCategoryId;

    private String name;
    private String description;

    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
    private List<Product> products;

}
