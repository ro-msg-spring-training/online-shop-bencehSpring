package ro.msg.learning.shop.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class LogInDTO {

    private String username;
    private String password;
    private String fullName;
    private String roles;
    private OrderDetailDTO cart;
}
