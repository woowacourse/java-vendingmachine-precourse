package vendingmachine.model.item.vo;

import static vendingmachine.exception.ExceptionMessage.NOT_POSITIVE_INTEGER_QUANTITY_EXCEPTION_MESSAGE;

public class Quantity {
    private static final String NOT_NEGATIVE_INTEGER_REGEX = "[0-9]+";
    private int value;

    public Quantity(final String value) {
        validatePositiveInteger(value);
        this.value = Integer.parseInt(value);
    }

    private void validatePositiveInteger(final String value) {
        if(!value.matches(NOT_NEGATIVE_INTEGER_REGEX) || value.equals("0")) {
            throw new IllegalArgumentException(NOT_POSITIVE_INTEGER_QUANTITY_EXCEPTION_MESSAGE);
        }
    }
}
