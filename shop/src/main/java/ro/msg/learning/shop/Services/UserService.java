package ro.msg.learning.shop.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.msg.learning.shop.Entities.User;
import ro.msg.learning.shop.Repositories.UserRepository;
import ro.msg.learning.shop.Exceptions.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User newUser) {
        return userRepository.save(newUser);
    }

    public User findById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        } else {
            throw new UserNotFoundException(id);
        }
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
