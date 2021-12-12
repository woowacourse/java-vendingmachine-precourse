package vendingmachine;

import java.util.HashSet;

public class Validator {
    private static final int MAX_PRODUCTS_TYPES = 10;
    private static final int MAX_PRODUCT_NAME_LENGTH = 10;
    private static final int MAX_PRODUCT_PRICE = 10000;
    private static final int MAX_PRODUCT_AMOUNT = 100;
    private static final int MAX_CASH = MAX_PRODUCTS_TYPES * MAX_PRODUCT_PRICE * MAX_PRODUCT_AMOUNT;
    private static HashSet<String> productSet = new HashSet<>();

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
        if (tokens.length < 3) {
            throw new MyIllegalArgumentException("Invalid format of input");
        }

        if (productSet.contains(tokens[0])) {
            throw new MyIllegalArgumentException(
                    String.format("Duplicated product [%s].", tokens[0])
            );
        }
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

        int nPrice = Integer.parseInt(price);

        if (nPrice > MAX_PRODUCT_PRICE) {
            throw new MyIllegalArgumentException(
                    String.format("Product price shouldn't be higher than %d", MAX_PRODUCT_PRICE)
            );
        }

        if (nPrice % 10 != 0) {
            throw new MyIllegalArgumentException("Price of product should be divided by 10");
        }
    }

    public static void validateProductTypes(int productTypes) {
        if (productTypes > MAX_PRODUCTS_TYPES) {
            throw new MyIllegalArgumentException(
                    String.format("Product types shouldn't be larger than %d", MAX_PRODUCTS_TYPES)
            );
        }
    }
}
