package ro.msg.learning.shop.exceptions;

public class ProductsNotAvailableException extends RuntimeException {

    public ProductsNotAvailableException(String message) {
        super(message);
    }
}

