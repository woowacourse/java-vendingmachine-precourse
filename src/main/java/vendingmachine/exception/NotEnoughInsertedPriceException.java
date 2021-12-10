package vendingmachine.exception;

public class NotEnoughInsertedPriceException extends RuntimeException{

    public NotEnoughInsertedPriceException() {
        super();
    }

    public NotEnoughInsertedPriceException(String message) {
        super(message);
    }

    public NotEnoughInsertedPriceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughInsertedPriceException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughInsertedPriceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
