package ro.msg.learning.shop.Exceptions;

public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException(String message) {
        super(message);
    }

}
