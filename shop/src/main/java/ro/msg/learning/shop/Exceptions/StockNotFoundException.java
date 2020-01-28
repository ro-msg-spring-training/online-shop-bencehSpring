package ro.msg.learning.shop.Exceptions;

public class StockNotFoundException extends RuntimeException {

    public StockNotFoundException(String message) {
        super(message);
    }

}
