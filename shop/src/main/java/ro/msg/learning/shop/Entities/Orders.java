package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Orders {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Location shippedFrom;

    @ManyToOne
    private User user;

    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "orders", cascade = CascadeType.ALL)
    private Adresa delivery;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetail;

}
