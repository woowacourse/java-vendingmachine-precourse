package vendingmachine.Constant;

public enum ProductConstant {
    PRODUCT_NAME_INDEX(0),
    PRODUCT_PRICE_INDEX (1),
    MINIMUM_DIVIDED_PRICE(10),
    PRODUCT_COUNT_INDEX(2),
    PRODUCT_INFO_SIZE(3);


    private final int constant;

    ProductConstant(int constant) {
        this.constant = constant;
    }

    public int getValue() {
        return constant;
    }
}
