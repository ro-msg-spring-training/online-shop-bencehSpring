package ro.msg.learning.shop.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.entities.Roles;
import ro.msg.learning.shop.repositories.RolesRepository;

@Service
@RequiredArgsConstructor
public class RolesService {

    private final RolesRepository rolesRepository;

    public Roles getRoleByName(String roleName) {
        return rolesRepository.findByRoleName(roleName);
    }
}
