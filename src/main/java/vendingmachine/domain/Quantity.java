package vendingmachine.domain;

import static vendingmachine.Constant.*;

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
            throw new IllegalArgumentException("상품의 수량은 0 이상이어야 합니다.");
        }
    }

    private int validateItIsNumber(String quantityInput) {
        if (!quantityInput.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException("상품의 수량은 숫자여야 합니다.");
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
