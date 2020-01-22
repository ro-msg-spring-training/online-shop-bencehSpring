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
@Table(name = "order_")
public class Order {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Location shippedFrom;

    @ManyToOne
    private User user;

    private LocalDateTime createdAt;

    @OneToOne( cascade = CascadeType.ALL)
    private Location deliveryLocation;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetail;

//    @Configuration
//    public class DeliveryStrategyConfiguration {
//
//        @Bean
//        public interface DeliveryStrategyInterface getDeliveryStrategy() {
//            StrategyEnum strategyValue = StrategyEnum.fromString(getFromProperties('strategyType'));
//
//            if (strategyValue == StrategyEnum.SINGLE_LOCATION) {
//                return new SingleLocationStrategy(); //care implementeaza deliverystrategyinterface si are metoda doAlgorithm
//            } else {
//                return new MostAbundantStrategy(); //care si ea implementeaza deliverystrategyinterface si are metoda doAlgoritm
//            }
//        }
//    }

}
