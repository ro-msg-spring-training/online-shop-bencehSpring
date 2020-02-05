package ro.msg.learning.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.dtos.LogInDTO;
import ro.msg.learning.shop.services.UserService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/login")
public class LogInController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LogInDTO logIn(@RequestBody LogInDTO logInDTO) {
        return userService.validateCredentials(logInDTO);
    }
}
