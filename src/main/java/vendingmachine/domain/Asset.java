package vendingmachine.domain;

import vendingmachine.util.Validator;

public class Asset {
    public static final String NOT_POSITIVE_NUMBER_EXCEPTION = "[ERROR] 0이상의 숫자를 입력해주세요.";

    private final Integer amount;

    public Asset(int amount) {
        validateNonNegative(amount);
        this.amount = amount;
    }
    public static void validateNonNegative(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_EXCEPTION);
        }
    }
}
