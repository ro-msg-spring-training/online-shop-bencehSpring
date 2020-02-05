package ro.msg.learning.shop.entities;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Product {

    @Id
    @Column(unique = true)
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer productId;
    private BigDecimal price;
    private Double weight;
    private String name;
    private String description;
    private String image;

    @ManyToOne
    private ProductCategory productCategory;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Stock> stocks;
}
