package vendingmachine.model.vo;

import static vendingmachine.validation.NumberValidator.isNotMultipleOfTen;
import static vendingmachine.validation.NumberValidator.isNotPositiveInteger;

import java.util.Objects;

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

    public void decreaseBy(final int itemPrice) {
        value -= itemPrice;
    }

    public boolean isLowerThan(final int itemPrice) {
        return value < itemPrice;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
