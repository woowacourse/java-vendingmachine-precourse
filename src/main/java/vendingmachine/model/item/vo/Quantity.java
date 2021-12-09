package vendingmachine.model.item.vo;

import static vendingmachine.exception.ExceptionMessage.NOT_POSITIVE_INTEGER_QUANTITY_EXCEPTION_MESSAGE;
import static vendingmachine.validation.NumberValidator.isNotPositiveInteger;

public class Quantity {
    private int value;

    public Quantity(final String value) {
        validatePositiveInteger(value);
        this.value = Integer.parseInt(value);
    }

    private void validatePositiveInteger(final String value) {
        if (isNotPositiveInteger(value)) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER_QUANTITY_EXCEPTION_MESSAGE);
        }
    }
}
