package vendingmachine.exception;

public class NotEnoughBalanceException extends RuntimeException{

    public NotEnoughBalanceException() {
        super();
    }

    public NotEnoughBalanceException(String message) {
        super(message);
    }

    public NotEnoughBalanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughBalanceException(Throwable cause) {
        super(cause);
    }

    protected NotEnoughBalanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
