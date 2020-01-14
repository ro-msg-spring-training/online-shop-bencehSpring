package ro.msg.learning.shop.Entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Builder
public class Revenue {

    @GeneratedValue
    @Id
    private Integer id;

    private Date localDate;
    private BigDecimal sum;

    @ManyToOne
    private Location location;

}
