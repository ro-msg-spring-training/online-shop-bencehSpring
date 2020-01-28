package ro.msg.learning.shop.Exceptions;

public class ProductsNotAvailableException extends RuntimeException {

    public ProductsNotAvailableException(String message) {
        super(message);
    }
}

