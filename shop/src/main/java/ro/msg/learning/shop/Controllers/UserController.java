package ro.msg.learning.shop.Controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.Entities.User;
import ro.msg.learning.shop.Services.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    @GetMapping()
    List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping()
    User newUser(@RequestBody User newUser) {
        return userService.save(newUser);
    }

    @GetMapping("/{id}")
    User getUser(@PathVariable Integer id) {

        return userService.findById(id);
    }

    @DeleteMapping("/{id}")
    void deleteUser(@PathVariable Integer id) {
        userService.deleteById(id);
    }
}
