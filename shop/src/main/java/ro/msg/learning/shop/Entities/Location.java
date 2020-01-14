package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Location {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
    private List<Stock> stocks;

    @OneToMany(mappedBy = "shippedFrom",cascade = CascadeType.ALL)
    private List<Orders> orders;

    @OneToOne(mappedBy = "location",cascade = CascadeType.ALL)
    private Adresa adresa;

    @OneToMany(mappedBy = "location",cascade = CascadeType.ALL)
    private List<Revenue> revenues;

}
