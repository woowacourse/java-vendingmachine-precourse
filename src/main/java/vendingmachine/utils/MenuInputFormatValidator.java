package vendingmachine.utils;

import static vendingmachine.constants.ExceptionMessages.*;
import static vendingmachine.constants.SystemConstants.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MenuInputFormatValidator {

    public static void validateMenuInputFormat(String menuInput) {
        validateNoSurroundingSemicolons(menuInput);
        String[] merchandiseInfos = menuInput.split(SEMICOLON);

        for (String merchandiseInfo : merchandiseInfos) {
            validateMerchandiseInfoFormat(merchandiseInfo);
        }

        validateNoDuplicateMerchandiseNames(merchandiseInfos);
    }

    private static void validateMerchandiseInfoFormat(String merchandiseInfo) {
        validateNotBlankInput(merchandiseInfo);
        validateSeparatorFormat(merchandiseInfo);

        String[] infoList = merchandiseInfo.substring(1, merchandiseInfo.length() - 1).split(COMMA);
        validateNameLength(infoList[NAME_IDX]);
        validatePriceInput(infoList[PRICE_IDX]);
        validateMerchandiseNumberInput(infoList[NUMBER_IDX]);
    }

    private static void validateNoSurroundingSemicolons(String menuInput) {
        if (menuInput.startsWith(SEMICOLON) || menuInput.endsWith(SEMICOLON)) {
            throw new IllegalArgumentException(SURROUNDED_BY_SEMICOLONS_EXCEPTION);
        }
    }

    private static void validateNotBlankInput(String merchandiseInfo) {
        if (merchandiseInfo.length() == 0) {
            throw new IllegalArgumentException(BLANK_INPUT_EXCEPTION);
        }
    }

    private static void validateSeparatorFormat(String merchandiseInfo) {
        validateSurroundingBrackets(merchandiseInfo);
        validateInternalSeparators(merchandiseInfo.substring(1, merchandiseInfo.length() - 1));
    }

    private static void validateSurroundingBrackets(String merchandiseInfo) {
        if (!merchandiseInfo.startsWith(BRACKET_OPEN) || !merchandiseInfo.endsWith(BRACKET_CLOSE)) {
            throw new IllegalArgumentException(NOT_SURROUNDED_BY_BRACKETS_EXCEPTION);
        }
    }

    private static void validateInternalSeparators(String content) {
        if (content.contains(BRACKET_OPEN) || content.contains(BRACKET_CLOSE)) {
            throw new IllegalArgumentException(INVALID_SEPARATORS_EXCEPTION);
        }

        if (content.split(COMMA).length != MERCHANDISE_INFO_TYPE_NUM) {
            throw new IllegalArgumentException(INVALID_COMMAS_EXCEPTION);
        }
    }

    private static void validateNameLength(String input) {
        if (input.length() == MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(BLANK_NAME_INPUT_EXCEPTION);
        }
    }

    private static void validatePriceInput(String input) {
        int price = validateIntType(input);
        validateNotLessThanHundred(price);
        NumberInputValidator.validateNotHaveOnesDigit(price);
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
        if (intInput < MINIMUM_PRICE) {
            throw new IllegalArgumentException(PRICE_NUMBER_LESS_THAN_HUNDRED_EXCEPTION);
        }
    }

    private static void validateNotNegativeNumber(int numberInput) {
        if (numberInput < MINIMUM_MONEY_INPUT) {
            throw new IllegalArgumentException(MERCHANDISE_NUMBER_NEGATIVE_NUMBER_EXCEPTION);
        }
    }

    private static void validateNoDuplicateMerchandiseNames(String[] merchandiseInfos) {
        List<String> merchandiseNames = new ArrayList<>();
        Set<String> merchandiseNameSet = new HashSet<>();

        for (String merchandiseInfo : merchandiseInfos) {
            String name = merchandiseInfo.substring(1).split(COMMA)[NAME_IDX];
            merchandiseNames.add(name);
            merchandiseNameSet.add(name);
        }

        if (merchandiseNames.size() > merchandiseNameSet.size()) {
            throw new IllegalArgumentException(DUPLICATE_MERCHANDISE_NAMES_EXCEPTION);
        }
    }
}
