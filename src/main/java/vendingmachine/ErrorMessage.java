package vendingmachine;

public enum ErrorMessage {
    NOT_NUMBER(new IllegalArgumentException("[ERROR] 금액은 숫자여야합니다."));

    private final RuntimeException exception;

    ErrorMessage(RuntimeException exception) {
        this.exception = exception;
    }

    public RuntimeException getException() {
        return exception;
    }
}
