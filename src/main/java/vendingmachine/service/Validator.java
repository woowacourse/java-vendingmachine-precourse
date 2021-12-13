package vendingmachine.service;


import static vendingmachine.view.Messages.*;

public class Validator {
    public static int checkNotString(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    public static void checkPositiveNumber(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_NUMBER);
        }
    }

    public static void checkDivideByTen(int price) {
        if (price % 10 != 0) {
            throw new IllegalArgumentException(ERROR_DIVIDE_BY_TEN);
        }
    }

    public static void checkProductStrBracket(String productStr) {
        if (productStr.charAt(0) != '[') {
            throw new IllegalArgumentException(ERROR_INVALID_BRACKET);
        }
        if (productStr.charAt(productStr.length() - 1) != ']') {
            throw new IllegalArgumentException(ERROR_INVALID_BRACKET);
        }
    }

    public static void checkProductNumOfInfo(String[] productInfo) {
        if (productInfo.length != 3) {
            throw new IllegalArgumentException(ERROR_INVALID_PRODUCT_INPUT);
        }
    }

    public static void checkFrontBlank(String input) {
        if (input.charAt(0) == ' ') {
            throw new IllegalArgumentException(ERROR_PRODUCT_NAME_BLANK);
        }
    }

    public static void checkEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }

    public static void checkPriceMinimumStandard(int price) {
        if (price < 100) {
            throw new IllegalArgumentException(ERROR_PRICE_MINIMUN_STANDARD);
        }
    }
}
