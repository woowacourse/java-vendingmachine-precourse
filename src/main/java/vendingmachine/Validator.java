package vendingmachine;

public class Validator {
    private static final int MAX_CASH_DIGIT = 5;
    private static final int MAX_PRODUCT_NAME_LENGTH = 10;
    private static final int MAX_PRODUCT_PRICE = 100000000;
    private static final int MAX_PRODUCT_AMOUNT = 100;

    public static void validateCashInput(String buffer) throws MyIllegalArgumentException {
        for (char c : buffer.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new MyIllegalArgumentException("Input must be a positive integer value");
            }
        }

        if (buffer.length() > MAX_CASH_DIGIT) {
            throw new MyIllegalArgumentException("Input value shouldn't be larger than 99999");
        }
    }

    public static void validateProductInput(String[] tokens) {
        if (tokens[0].length() > MAX_PRODUCT_NAME_LENGTH) {
            throw new MyIllegalArgumentException(
                    String.format("Product name shouldn't be longer than %d", MAX_PRODUCT_NAME_LENGTH)
            );
        }

        for (char c : tokens[1].toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new MyIllegalArgumentException("Price of product must be a positive integer value");
            }
        }

        if (Integer.parseInt(tokens[1]) > MAX_PRODUCT_PRICE) {
            throw new MyIllegalArgumentException(
                    String.format("Product price shouldn't be higher than %d", MAX_PRODUCT_PRICE)
            );
        }

        for (char c : tokens[2].toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new MyIllegalArgumentException("Amount of product must be a positive integer value");
            }
        }

        if (Integer.parseInt(tokens[2]) > MAX_PRODUCT_AMOUNT) {
            throw new MyIllegalArgumentException(
                    String.format("Product amount shouldn't be larger than %d", MAX_PRODUCT_AMOUNT)
            );
        }
    }
}
