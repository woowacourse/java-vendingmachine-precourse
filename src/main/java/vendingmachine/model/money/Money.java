package vendingmachine.model.money;

import static vendingmachine.exception.ExceptionMessage.NOT_POSITIVE_INTEGER_EXCEPTION_MESSAGE;
import static vendingmachine.exception.ExceptionMessage.NOT_MULTIPLE_OF_TEN_EXCEPTION_MESSAGE;

public class Money {
    private static final String NOT_NEGATIVE_INTEGER_REGEX = "[0-9]+";
    private int value;

    public Money(final String value) {
        validatePositiveInteger(value);
        int integerValue = Integer.parseInt(value);
        validateMultipleOfTen(integerValue);
        this.value = integerValue;
    }

    private void validatePositiveInteger(final String value) {
        if (!value.matches(NOT_NEGATIVE_INTEGER_REGEX) || value.equals("0")) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER_EXCEPTION_MESSAGE);
        }
    }

    private void validateMultipleOfTen(final int value) {
        if (value % 10 != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_TEN_EXCEPTION_MESSAGE);
        }
    }
}
