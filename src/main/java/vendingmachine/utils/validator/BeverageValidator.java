package vendingmachine.utils.validator;

import vendingmachine.utils.ExceptionMessage;

import java.util.regex.Pattern;

public class BeverageValidator {
    private static final String REGEX = "[a-zA-Z0-9가-힣]+,\\d{3,}+,\\d+";
    private static final String DELIMITER = ",";

    private static final char START_CHAR = '[';
    private static final char END_CHAR = ']';

    private static final int SUBSTRING_IDX = 1;
    private static final int FIRST_INDEX = 0;
    private static final int FALSE_NUMBER = 0;
    private static final int DIVIDE_STANDARD = 10;
    private static final int PRICE_IDX = 1;
    private static final int AMOUNT_IDX = 2;

    public static String[] validateInput(String input) {
        isFirstAndLastCharRight(input);

        String removedInput = input.substring(SUBSTRING_IDX, input.length() - SUBSTRING_IDX);
        isMatchRegex(removedInput);

        String[] tempBeverage = removedInput.split(DELIMITER);
        isPriceNotDivideByTen(tempBeverage[PRICE_IDX]);
        isAmountUnderZero(tempBeverage[AMOUNT_IDX]);

        return tempBeverage;
    }

    private static void isMatchRegex(String removedInput) {
        if (!Pattern.matches(REGEX, removedInput)) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_BEVERAGE_FORMAT);
        }
    }

    private static void isFirstAndLastCharRight(String input) {
        if (input.charAt(FIRST_INDEX) != START_CHAR || input.charAt(input.length() - 1) != END_CHAR) {
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
