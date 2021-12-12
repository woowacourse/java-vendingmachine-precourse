package vendingmachine.exception;

public class MoneyPositiveIntegerValueException extends IllegalArgumentException {

    private static final String MONEY_POSITIVE_INTEGER_VALUE_ERROR_MESSAGE = "[ERROR] 금액은 양의 숫자여야 합니다.";

    public MoneyPositiveIntegerValueException() {
        super(MONEY_POSITIVE_INTEGER_VALUE_ERROR_MESSAGE);
    }
}
