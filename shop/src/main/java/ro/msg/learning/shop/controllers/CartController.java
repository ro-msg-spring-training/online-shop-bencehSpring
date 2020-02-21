package ro.msg.learning.shop.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.msg.learning.shop.services.CartService;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/cart")
public class CartController {

    private final CartService cartService;

    @DeleteMapping("/{id}/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteCart(@PathVariable Integer id, @PathVariable String username) {
        cartService.deleteById(id, username);
    }

    @DeleteMapping("/{username}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUsersCart(@PathVariable String username) {
        cartService.deleteByUser(username);
    }
}
