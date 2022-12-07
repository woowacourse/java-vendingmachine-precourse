package vendingmachine.util;

public enum Constants {
    PRODUCT_NAME_INDEX(0),
    PRODUCT_PRICE_INDEX(1),
    PRODUCT_QUANTITY_INDEX(2);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
