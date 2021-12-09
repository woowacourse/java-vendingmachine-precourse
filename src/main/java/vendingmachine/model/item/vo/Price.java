package vendingmachine.model.item.vo;

import static vendingmachine.exception.ExceptionMessage.*;
import static vendingmachine.validation.NumberValidator.isNotMultipleOfTen;
import static vendingmachine.validation.NumberValidator.isNotPositiveInteger;

import java.util.Objects;

public class Price {
    private static final int MIN_VALUE = 100;
    private final int value;

    public Price(final String value) {
        validatePositiveInteger(value);
        int integerValue = Integer.parseInt(value);
        validateMinValue(integerValue);
        validateMultipleOfTen(integerValue);
        this.value = integerValue;
    }

    private void validatePositiveInteger(final String value) {
        if (isNotPositiveInteger(value)) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER_PRICE_EXCEPTION_MESSAGE);
        }
    }

    private void validateMultipleOfTen(final int value) {
        if (isNotMultipleOfTen(value)) {
            throw new IllegalArgumentException(NOT_MULTIPLE_OF_TEN_PRICE_EXCEPTION_MESSAGE);
        }
    }

    private void validateMinValue(final int value) {
        if (value < MIN_VALUE) {
            throw new IllegalArgumentException(PRICE_MIN_VALUE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Price price = (Price) o;
        return value == price.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
