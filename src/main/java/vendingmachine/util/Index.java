package vendingmachine.util;

public enum Index {
    PRODUCT_NAME_INDEX(0),
    PRODUCT_PRICE_INDEX(1),
    PRODUCT_QUANTITY_INDEX(2);

    private final int index;

    Index(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}
