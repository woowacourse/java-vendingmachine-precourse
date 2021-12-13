package vendingmachine.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static vendingmachine.utils.ExceptionMessages.*;

public class StringFormatValidator {

    public static void validateMenuInputFormat(String[] merchandiseInfos) {
        for (String merchandiseInfo : merchandiseInfos) {
            validateMerchandiseInfoFormat(merchandiseInfo);
        }
        validateNoDuplicateMerchandiseNames(merchandiseInfos);
    }

    private static void validateMerchandiseInfoFormat(String merchandiseInfo) {
        validateBracketFormat(merchandiseInfo);
        String[] infoList = merchandiseInfo.substring(1, merchandiseInfo.length() - 1).split(",");
        String name = infoList[0];

        validatePriceInput(infoList[1]);
        validateMerchandiseNumberInput(infoList[2]);
    }

    private static void validateBracketFormat(String merchandiseInfo) {
        if (!merchandiseInfo.startsWith("[") || !merchandiseInfo.endsWith("]")) {
            throw new IllegalArgumentException(NOT_SURROUNDED_BY_BRACKETS_EXCEPTION);
        }
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

    private static void validateNoDuplicateMerchandiseNames(String[] merchandiseInfos) {
        List<String> merchandiseNames = new ArrayList<>();
        Set<String> merchandiseNameSet = new HashSet<>();

        for (String merchandiseInfo : merchandiseInfos) {
            String price = merchandiseInfo.substring(1).split(",")[0];
            merchandiseNames.add(price);
            merchandiseNameSet.add(price);
        }

        if (merchandiseNames.size() > merchandiseNameSet.size()) {
            throw new IllegalArgumentException(DUPLICATE_MERCHANDISE_NAMES_EXCEPTION);
        }
    }
}
