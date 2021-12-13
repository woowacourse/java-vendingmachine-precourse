package vendingmachine;

public class ProductQuantity {
    private static final String QUANTITY_NOT_NUMERIC_MESSAGE = "상품 수량은 정수만 입력 가능합니다.";

    private int quantity;

    public ProductQuantity(String quantityString) {
        validateQuantityNumeric(quantityString);
        this.quantity = Integer.parseInt(quantityString);
    }

    public int get() {
        return quantity;
    }

    private void validateQuantityNumeric(String quantity) {
        if (!StringUtils.isNumeric(quantity)) {
            throw new IllegalArgumentException(QUANTITY_NOT_NUMERIC_MESSAGE);
        }
    }

}
