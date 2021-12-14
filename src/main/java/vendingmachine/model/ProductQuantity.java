package vendingmachine.model;

import vendingmachine.utils.StringUtils;

import java.util.Objects;

public class ProductQuantity {
    private static final String QUANTITY_NOT_NUMERIC_MESSAGE = "상품 수량은 정수만 입력 가능합니다.";
    private static final String QUANTITY_NOT_ENOUGH_MESSAGE = "상품 재고가 부족합니다.";
    private static final int NO_STOCK = 0;

    private int quantity;

    public ProductQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductQuantity(String quantityString) {
        validateQuantityNumeric(quantityString);
        this.quantity = Integer.parseInt(quantityString);
    }

    public int get() {
        return quantity;
    }

    public void validateEnoughStock() {
        if (!canBuy()) {
            throw new IllegalArgumentException(QUANTITY_NOT_ENOUGH_MESSAGE);
        }
    }

    public boolean canBuy() {
        return quantity > NO_STOCK;
    }

    public void decrease() {
        quantity--;
    }

    private void validateQuantityNumeric(String quantity) {
        if (!StringUtils.isNumeric(quantity)) {
            throw new IllegalArgumentException(QUANTITY_NOT_NUMERIC_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductQuantity that = (ProductQuantity) o;
        return quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

}
