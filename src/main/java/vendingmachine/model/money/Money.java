package vendingmachine.model.money;

import static vendingmachine.exception.ExceptionMessage.NOT_POSITIVE_INTEGER_EXCEPTION_MESSAGE;
import static vendingmachine.exception.ExceptionMessage.NOT_MULTIPLE_OF_TEN_EXCEPTION_MESSAGE;
import static vendingmachine.validation.NumberValidator.isNotMultipleOfTen;
import static vendingmachine.validation.NumberValidator.isNotPositiveInteger;

public class Money {
    private int value;

    public Money(final String value) {
        validatePositiveInteger(value);
        int integerValue = Integer.parseInt(value);
        validateMultipleOfTen(integerValue);
        this.value = integerValue;
    }

    private void validatePositiveInteger(final String value) {
        if (isNotPositiveInteger(value)) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER_EXCEPTION_MESSAGE);
        }
    }

    private void validateMultipleOfTen(final int value) {
        if (isNotMultipleOfTen(value)) {
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_TEN_EXCEPTION_MESSAGE);
        }
    }
}
