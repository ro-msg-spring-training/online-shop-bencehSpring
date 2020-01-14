package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class OrderDetail {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer quantity;

    @OneToMany(mappedBy = "orderDetail",cascade = CascadeType.ALL)
    private List<Product> products;

    @OneToOne
    private Orders orders;
}
