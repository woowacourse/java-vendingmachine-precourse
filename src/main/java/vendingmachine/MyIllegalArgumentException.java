package vendingmachine;

public class MyIllegalArgumentException extends IllegalArgumentException{
    private static final String MESSAGE_BASE = "[ERROR] %s";

    public MyIllegalArgumentException(String message) {
        super(String.format(MESSAGE_BASE, message));
    }
}
