package ro.msg.learning.shop.Exceptions;

import java.util.function.Supplier;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Integer id) {
        super("Could not find user " + id);
    }

}
