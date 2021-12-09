package vendingmachine.domain;

import static vendingmachine.Constant.*;

public class Quantity {
    public Quantity(String quantityInput) {
        validate(quantityInput);
    }

    public void validate(String quantityInput) {
        int quantity = validateItIsNumber(quantityInput);
        validateItIsPositive(quantity);
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
}
