package ro.msg.learning.shop.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserDTO implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private String fullName;
    private String emailAddress;
    private RoleDTO role;
    private List<CartDTO> cart;
}
