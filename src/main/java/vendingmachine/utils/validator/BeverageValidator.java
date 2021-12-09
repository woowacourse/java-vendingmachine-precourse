package vendingmachine.utils.validator;

import vendingmachine.utils.ExceptionMessage;

public class BeverageValidator {
    private static final String REGEX = "\\[[a-zA-Z0-9가-힣]+,\\d{3,}+,\\d+]";
    private static final String DELIMITER = ",";

    private static final int SUBSTRING_IDX = 1;
    private static final int FALSE_NUMBER = 0;
    private static final int DIVIDE_STANDARD = 10;
    private static final int PRICE_IDX = 1;
    private static final int AMOUNT_IDX = 2;

    public static String[] validateInput(String input) {
        isMatchRegex(input);
        String removedInput = input.substring(SUBSTRING_IDX, input.length() - SUBSTRING_IDX);
        String[] tempBeverage = removedInput.split(DELIMITER);
        isPriceNotDivideByTen(tempBeverage[PRICE_IDX]);
        isAmountUnderZero(tempBeverage[AMOUNT_IDX]);

        return tempBeverage;
    }

    private static void isMatchRegex(String removedInput) {
        if (!removedInput.matches(REGEX)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_BEVERAGE_FORMAT);
        }
    }

    private static void isPriceNotDivideByTen(String input) {
        if (Integer.parseInt(input) % DIVIDE_STANDARD != FALSE_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_BEVERAGE_FORMAT);
        }
    }

    private static void isAmountUnderZero(String input) {
        if (Integer.parseInt(input) <= FALSE_NUMBER) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_BEVERAGE_FORMAT);
        }
    }
}
