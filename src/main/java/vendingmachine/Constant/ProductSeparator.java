package vendingmachine.Constant;

public enum ProductSeparator {
    ORDER_PREFIX('['),
    ORDER_SUFFIX(']'),
    ORDER_SEPARATOR(';'),
    PRODUCT_INFO_SEPARATOR(',');

    private final char character;

    public static final String PRICE = "PRICE";
    public static final String COUNT = "COUNT";

    ProductSeparator(char character) {
        this.character = character;
    }

    public char getChar() {
        return character;
    }

    @Override
    public String toString() {
        return String.valueOf(this.character);
    }
}
