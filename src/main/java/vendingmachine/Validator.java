package vendingmachine;

public class Validator {
    private static final int MAX_PRODUCTS_TYPES = 10;
    private static final int MAX_PRODUCT_NAME_LENGTH = 10;
    private static final int MAX_PRODUCT_PRICE = 10000;
    private static final int MAX_PRODUCT_AMOUNT = 100;
    private static final int MAX_CASH = MAX_PRODUCTS_TYPES * MAX_PRODUCT_PRICE * MAX_PRODUCT_AMOUNT;

    public static void validateCashInput(String buffer) throws IllegalArgumentException {
        for (char c : buffer.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new MyIllegalArgumentException("Input must be a positive integer value");
            }
        }

        if (Integer.parseInt(buffer) > MAX_CASH) {
            throw new MyIllegalArgumentException("Input value shouldn't be larger than 99999");
        }
    }

    public static void validateProductInput(String[] tokens) throws IllegalArgumentException {
        validateProductName(tokens[0]);
        validateProductPrice(tokens[1]);
        validateProductAmount(tokens[2]);
    }

    private static void validateProductAmount(String amount) throws IllegalArgumentException {
        for (char c : amount.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new MyIllegalArgumentException("Amount of product must be a positive integer value");
            }
        }

        if (Integer.parseInt(amount) > MAX_PRODUCT_AMOUNT) {
            throw new MyIllegalArgumentException(
                    String.format("Product amount shouldn't be larger than %d", MAX_PRODUCT_AMOUNT)
            );
        }
    }

    public static void validateProductName(String name) throws IllegalArgumentException {
        if (name.length() > MAX_PRODUCT_NAME_LENGTH) {
            throw new MyIllegalArgumentException(
                    String.format("Product name shouldn't be longer than %d", MAX_PRODUCT_NAME_LENGTH)
            );
        }
    }

    public static void validateProductPrice(String price) throws IllegalArgumentException {
        for (char c : price.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new MyIllegalArgumentException("Price of product must be a positive integer value");
            }
        }

        if (Integer.parseInt(price) > MAX_PRODUCT_PRICE) {
            throw new MyIllegalArgumentException(
                    String.format("Product price shouldn't be higher than %d", MAX_PRODUCT_PRICE)
            );
        }
    }

    public static void validateProductsTypes(int productTypes) {
        if (productTypes > MAX_PRODUCT_PRICE) {
            throw new MyIllegalArgumentException(
                    String.format("Product types shouldn't be larger than %d", MAX_PRODUCTS_TYPES)
            );
        }
    }
}
