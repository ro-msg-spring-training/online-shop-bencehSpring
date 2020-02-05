package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.UserDTO;
import ro.msg.learning.shop.entities.User;

@Component
@RequiredArgsConstructor
public class UserMapper {

    private final RoleMapper roleMapper;

    public UserDTO mapUserToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getUserId())
                .fullName(user.getFistName() + " " + user.getLastName())
                .password(user.getPassword())
                .username(user.getUsername())
                .role(roleMapper.mapRoleToRoleDTO(user.getRole()))
                .build();
    }
}
