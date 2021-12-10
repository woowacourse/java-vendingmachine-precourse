package vendingmachine.model.vo;

import static vendingmachine.validation.NumberValidator.isNotMultipleOfTen;
import static vendingmachine.validation.NumberValidator.isNotPositiveInteger;

public class Money {
    private static final String NOT_POSITIVE_INTEGER_EXCEPTION_MESSAGE = "금액은 양의 정수여야 합니다.";
    private static final String NOT_MULTIPLE_OF_TEN_EXCEPTION_MESSAGE = "금액의 최소 단위는 10원입니다.";
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
