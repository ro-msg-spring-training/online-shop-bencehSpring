package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Adresa {

    @Id
    @GeneratedValue
    private Integer id;

    private String country;
    private String city;
    private String street;

    @OneToOne
    private Orders orders;

    @OneToOne
    private Location location;
}
