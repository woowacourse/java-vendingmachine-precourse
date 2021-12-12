package vendingmachine.validator;

import static vendingmachine.utils.ExceptionMessages.*;

public class StringFormatValidator {

    public static void validateMenuInputFormat(String[] merchandiseInfos) {
        for (String merchandiseInfo : merchandiseInfos) {
            validateMerchandiseInfoFormat(merchandiseInfo);
        }
    }

    private static void validateMerchandiseInfoFormat(String merchandiseInfo) {
        String[] infoList = merchandiseInfo.substring(1, merchandiseInfo.length() - 1).split(",");
        String name = infoList[0];

        validatePriceInput(infoList[1]);
        validateMerchandiseNumberInput(infoList[2]);
    }

    private static void validatePriceInput(String input) {
        int price = validateIntType(input);
        validateNotLessThanHundred(price);
        NumberValidator.validateNotHaveOnesDigit(price);
    }

    private static void validateMerchandiseNumberInput(String input) {
        int number = validateIntType(input);
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
