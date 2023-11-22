package vendingmachine.exception;

public enum ErrorMessage {
    CAPTION("[ERROR] "),
    INVALID_VENDING_MACHINE_COINS("금액은 숫자여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return CAPTION.message + message;
    }
}
