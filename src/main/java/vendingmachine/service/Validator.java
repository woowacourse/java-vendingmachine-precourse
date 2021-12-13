package vendingmachine.service;

import static vendingmachine.view.Messages.*;

public class Validator {
    public static final char PRODUCT_OPEN_BRACKET = '[';
    public static final char PRODUCT_CLOSE_BRACKET = ']';
    public static final char BLANK_CHAR = ' ';
    public static final int PRODUCT_ITEM_NUM = 3;
    public static final int MINIMUN_PRODUCT_PRICE = 100;
    public static final int PRICE_DIVIDE_STANDARD = 10;
    public static final int FIRST_CHAR = 0;

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
        if (price % PRICE_DIVIDE_STANDARD != 0) {
            throw new IllegalArgumentException(ERROR_DIVIDE_BY_TEN);
        }
    }

    public static void checkProductStrBracket(String productStr) {
        if (productStr.charAt(FIRST_CHAR) != PRODUCT_OPEN_BRACKET) {
            throw new IllegalArgumentException(ERROR_INVALID_BRACKET);
        }
        if (productStr.charAt(productStr.length() - 1) != PRODUCT_CLOSE_BRACKET) {
            throw new IllegalArgumentException(ERROR_INVALID_BRACKET);
        }
    }

    public static void checkProductNumOfInfo(String[] productInfo) {
        if (productInfo.length != PRODUCT_ITEM_NUM) {
            throw new IllegalArgumentException(ERROR_INVALID_PRODUCT_INPUT);
        }
    }

    public static void checkFrontBlank(String input) {
        if (input.charAt(FIRST_CHAR) == BLANK_CHAR) {
            throw new IllegalArgumentException(ERROR_PRODUCT_NAME_BLANK);
        }
    }

    public static void checkEmptyInput(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }

    public static void checkPriceMinimumStandard(int price) {
        if (price < MINIMUN_PRODUCT_PRICE) {
            throw new IllegalArgumentException(ERROR_PRICE_MINIMUN_STANDARD);
        }
    }
}
