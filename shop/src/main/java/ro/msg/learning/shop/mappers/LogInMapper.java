package ro.msg.learning.shop.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ro.msg.learning.shop.dtos.LogInDTO;
import ro.msg.learning.shop.entities.User;

@Component
@RequiredArgsConstructor
public class LogInMapper {
    public LogInDTO mapUserToLogInDTO(User user) {
        return LogInDTO.builder()
                .username(user.getUsername())
                .fullName(user.getFistName() + " " + user.getLastName())
                .password(user.getPassword())
                .roles(user.getRole().getRoleName())
                .build();
    }
}
