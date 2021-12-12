package vendingmachine.model.Item;

import vendingmachine.util.validator.Validator;

public class Quantity {
    int quantity;

    public Quantity(String quantity) {
        validQuantity(quantity);
        this.quantity = Integer.parseInt(quantity);
    }

    private void validQuantity(String quantity) {
        Validator.validateInteger(quantity);
        Validator.validateNonNegative(Integer.parseInt(quantity));
    }

    public boolean isNotZero() {
        return quantity != 0;
    }

    public Quantity decrease() {
        this.quantity -= 1;
        return this;
    }

    @Override
    public String toString() {
        return Integer.toString(quantity);
    }
}
