package ro.msg.learning.shop.Exceptions;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(String message)
    {
        super(message);
    }
}
