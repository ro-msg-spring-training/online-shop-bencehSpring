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
public class User
{
    @Id
    @GeneratedValue
    private Integer userId;

    private String fistName;
    private String lastName;
    private String username;
    private String password;
    private String emailAddress;

    //many users to one role
    @ManyToOne
    private Roles role;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    public User (String fistName)
    {
        this.fistName=fistName;
    }
}
