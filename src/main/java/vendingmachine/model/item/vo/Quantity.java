package vendingmachine.model.item.vo;

import static vendingmachine.validation.NumberValidator.isNotPositiveInteger;

public class Quantity {
    private static final String NOT_POSITIVE_INTEGER_QUANTITY_EXCEPTION_MESSAGE = "상품 수량은 양의 정수여야 합니다.";
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

    public void decrease() {
        value--;
    }

    public boolean isZero() {
        return value == 0;
    }
}
