package vendingmachine;

import java.util.Arrays;

public class Validator {
    private static final int PRODUCT_INFO_LENGTH = 3;
    private static final int MINIMUM_PRICE = 100;
    private static final int COMMON_MULTIPLE = 10;

    public static void validateMachineMoneyInput(String input) throws IllegalArgumentException {
        validateInputIsPositiveNumber(input);
        validateInputIsMultipleOf10(input);
    }

    private static void validateInputIsPositiveNumber(String input) throws IllegalArgumentException {
        if (!isPositiveNumber(input)) {
            throw new IllegalArgumentException(Constant.MACHINE_MONEY_INPUT_IS_NOT_POSITIVE_NUMBER_ERROR_STRING);
        }
    }

    private static void validateInputIsMultipleOf10(String input) throws IllegalArgumentException {
        if (Integer.parseInt(input) % COMMON_MULTIPLE != 0) {
            throw new IllegalArgumentException(Constant.MACHINE_MONEY_INPUT_IS_NOT_MULTIPLE_OF_10);
        }
    }

    private static boolean isPositiveNumber(String input) throws IllegalArgumentException {
        try {
            if (Integer.parseInt(input) > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return false;
    }

    public static void validateMachineProductInput(String input) throws IllegalArgumentException {
        String[] products = input.split(";");

        for (String product : products) {
            validateSingleProductInput(product);
        }
    }

    private static void validateSingleProductInput(String product) {
        String disClosed = product.replaceAll("[]\\[]", "");
        String[] elements = Arrays.stream(disClosed.split(","))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);

        validateInputEnclosedInBracket(product);
        validateProductContainThreeElements(elements);
        validateProductPriceAndQuantityIsPositiveNumber(elements[1], elements[2]);
        validateProductPrice(Integer.parseInt(elements[1]));
    }

    private static void validateInputEnclosedInBracket(String product) throws IllegalArgumentException {
        if (!product.startsWith("[") || !product.endsWith("]")) {
            throw new IllegalArgumentException(Constant.MACHINE_PRODUCT_INPUT_IS_NOT_RIGHT_FORM_ERROR_STRING);
        }
    }

    private static void validateProductContainThreeElements(String[] elements) throws IllegalArgumentException {
        if (elements.length != PRODUCT_INFO_LENGTH) {
            throw new IllegalArgumentException(Constant.MACHINE_PRODUCT_INPUT_IS_NOT_RIGHT_FORM_ERROR_STRING);
        }
    }

    private static void validateProductPriceAndQuantityIsPositiveNumber(String price, String quantity) throws IllegalArgumentException {
        if (!isPositiveNumber(price) || !isPositiveNumber(quantity)) {
            throw new IllegalArgumentException(Constant.MACHINE_PRODUCT_INPUT_PRICE_QUANTITY_FORM_ERROR_STRING);
        }
    }

    private static void validateProductPrice(int price) throws IllegalArgumentException {
        if (price < MINIMUM_PRICE || price % COMMON_MULTIPLE != 0) {
            throw new IllegalArgumentException(Constant.MACHINE_PRODUCT_INPUT_PRICE_ERROR_STRING);
        }
    }

    public static void validateUserMoneyInput(String input) throws IllegalArgumentException {
        validateInputIsPositiveNumber(input);
        validateInputIsMultipleOf10(input);
    }
}
