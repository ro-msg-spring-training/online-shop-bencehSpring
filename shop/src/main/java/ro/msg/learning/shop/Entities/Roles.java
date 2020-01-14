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
public class Roles {

    @Id
    @GeneratedValue
    private Integer roleId;
    private String roleName;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users;

}
