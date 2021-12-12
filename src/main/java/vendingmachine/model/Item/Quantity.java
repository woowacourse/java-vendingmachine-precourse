package vendingmachine.model.Item;

import vendingmachine.util.Validator;

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

    @Override
    public String toString() {
        return Integer.toString(quantity);
    }
}
