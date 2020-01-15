package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;

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

    private Integer productId;

    @ManyToOne
    private Orders order;
}
