package vendingmachine.domain.products;

import vendingmachine.exception.QuantityRangeException;

public class Quantity {

    private static final int MIN_QUANTITY = 0;
    private static final int MAX_QUANTITY = 1_000_000_000;

    private int quantity;

    private Quantity(int quantity) {
        validate(quantity);
        this.quantity = quantity;
    }

    public static Quantity from(int quantity) {
        return new Quantity(quantity);
    }

    private void validate(int quantity) {
        validateRange(quantity);
    }

    private static void validateRange(int quantity) {
        if (quantity < MIN_QUANTITY || quantity > MAX_QUANTITY) {
            throw new QuantityRangeException(MIN_QUANTITY, MAX_QUANTITY);
        }
    }

    public boolean isRemain() {
        return quantity > MIN_QUANTITY;
    }

    public void decrease() {
        this.quantity--;
    }
}
