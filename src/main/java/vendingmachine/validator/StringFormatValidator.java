package vendingmachine.validator;

import static vendingmachine.utils.ExceptionMessages.*;

public class StringFormatValidator {

    public static void validateMerchandiseInfoFormat(String merchandiseInfo) {
        String[] infoList = merchandiseInfo.substring(1, merchandiseInfo.length() - 1).split(",");
        String name = infoList[0];
        validateIntType(infoList[1]);
        validateIntType(infoList[2]);
        int price = Integer.parseInt(infoList[1]);
        validateNotLessThanHundred(price);
        NumberValidator.validateNotHaveOnesDigit(price);
        int number = Integer.parseInt(infoList[2]);
        validateNotNegativeNumber(number);
    }

    private static int validateIntType(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(PRICE_NUMBER_NOT_NUMBER_EXCEPTION);
        }
    }

    private static void validateNotLessThanHundred(int intInput) {
        if (intInput < 100) {
            throw new IllegalArgumentException(PRICE_NUMBER_LESS_THAN_HUNDRED_EXCEPTION);
        }
    }

    private static void validateNotNegativeNumber(int numberInput) {
        if (numberInput < 0) {
            throw new IllegalArgumentException(MERCHANDISE_NUMBER_NEGATIVE_NUMBER_EXCEPTION);
        }
    }
}
