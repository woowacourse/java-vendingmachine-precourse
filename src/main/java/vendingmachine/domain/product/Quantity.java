package vendingmachine.domain.product;

public class Quantity {
    private static final int DEFAULT_QUANTITY = 0;

    private static final String VALID_NUMBER_FORMAT = "[ERROR] 상품 수량은 숫자여야 합니다.";
    private static final String VALID_LEAST_QUANTITY = "[ERROR] 상품 수량은 최소 1개 이상이어야 합니다.";

    private int quantity;

    public Quantity(String inputQuantity) {
        validateQuantity(inputQuantity);
        this.quantity = Integer.parseInt(inputQuantity);
    }

    private void validateQuantity(String inputQuantity) {
        validateNumberFormat(inputQuantity);
        int quantity = Integer.parseInt(inputQuantity);
        validateLeastQuantity(quantity);
    }

    private void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALID_NUMBER_FORMAT);
        }
    }

    private void validateLeastQuantity(int quantity) {
        if (quantity <= DEFAULT_QUANTITY) {
            throw new IllegalArgumentException(VALID_LEAST_QUANTITY);
        }
    }

    public boolean isExistQuantity() {
        if (quantity > DEFAULT_QUANTITY) {
            return true;
        }
        return false;
    }

    public void decreaseQuantity() {
        --quantity;
    }
}