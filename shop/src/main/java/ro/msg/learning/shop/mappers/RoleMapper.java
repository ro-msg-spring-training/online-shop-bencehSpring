package ro.msg.learning.shop.mappers;

import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.RoleDTO;
import ro.msg.learning.shop.entities.Roles;

@Component
public class RoleMapper {

    public RoleDTO mapRoleToRoleDTO(Roles role) {
        return RoleDTO.builder()
                .id(role.getRoleId())
                .roleName(role.getRoleName())
                .build();
    }
}
