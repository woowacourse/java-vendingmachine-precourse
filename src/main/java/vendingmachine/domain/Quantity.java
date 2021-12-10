package vendingmachine.domain;

import static vendingmachine.Constant.*;
import static vendingmachine.ErrorMessage.*;

public class Quantity {
    private int quantity;

    public Quantity(String quantityInput) {
        this.quantity = validate(quantityInput);
    }

    public int validate(String quantityInput) {
        int quantity = validateItIsNumber(quantityInput);
        validateItIsPositive(quantity);
        return quantity;
    }

    private void validateItIsPositive(int quantity) {
        if (quantity < ZERO) {
            throw new IllegalArgumentException(QUANTITY_RANGE_ERROR_MESSAGE);
        }
    }

    private int validateItIsNumber(String quantityInput) {
        if (!quantityInput.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(QUANTITY_NOT_NUMBER_ERROR_MESSAGE);
        }
        return Integer.parseInt(quantityInput);
    }

    public int getQuantity() {
        return quantity;
    }

    public void takeOutInWarehouse() {
        this.quantity -= 1;
    }
}
