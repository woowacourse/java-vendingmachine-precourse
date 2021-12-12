package vendingmachine;

public enum ErrorMessage {
    NOT_NUMBER(new IllegalArgumentException("[ERROR] 금액은 숫자여야 합니다.")),
    NOT_DIVISIBLE_VALUE(new IllegalArgumentException("[ERROR] 금액은 10원으로 나누어져야 합니다.")),
    NOT_NATURAL_NUMBER(new IllegalArgumentException("[ERROR] 금액은 0원을 넘어야합니다."));

    private final RuntimeException exception;

    ErrorMessage(RuntimeException exception) {
        this.exception = exception;
    }

    public RuntimeException getException() {
        return exception;
    }
}
