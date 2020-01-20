package ro.msg.learning.shop.Entities;

import lombok.*;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
@Table(name = "address_")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String country;
    private String city;
    private String street;

    @OneToOne(cascade = CascadeType.ALL)
     private Order order;

    @OneToOne
    private Location location;
}
