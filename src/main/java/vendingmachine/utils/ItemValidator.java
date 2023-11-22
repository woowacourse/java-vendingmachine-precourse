package vendingmachine.utils;

import org.junit.platform.commons.util.StringUtils;

import java.util.List;

import static vendingmachine.exception.ErrorMessage.*;

public class ItemValidator {
    private static final int MINIMUM_PRICE = 100;
    private static final int PRICE_UNIT = 10;

    public static List<String> safeSplit(String input, String delimiter) {
        validateEmpty(input);
        validateStartsOrEndsWithDelimiter(input, delimiter);
        return List.of(input.split(delimiter));
    }

    private static void validateEmpty(String input) {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException(INVALID_ITEMS_FORMAT.getMessage());
        }
    }

    private static void validateStartsOrEndsWithDelimiter(String input, String delimiter) {
        if (input.startsWith(delimiter) || input.endsWith(delimiter)) {
            throw new IllegalArgumentException(INVALID_ITEMS_FORMAT.getMessage());
        }
    }

    public static String validateAndCleanPair(String input, String startDelimiter, String endDelimiter) {
        if (!input.startsWith(startDelimiter) || !input.endsWith(endDelimiter)) {
            throw new IllegalArgumentException(INVALID_ITEMS_FORMAT.getMessage());
        }
        return input.substring(1, input.length() - 1);
    }

    public static long safeParsePositiveLong(String input) {
        try {
            long value = Long.parseLong(input);
            validatePositive(value);
            return value;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_ITEMS_FORMAT.getMessage());
        }
    }

    private static void validatePositive(long value) {
        if (value <= 0) {
            throw new IllegalArgumentException(INVALID_ITEM_DETAIL.getMessage());
        }
    }

    public static void validatePrice(long price) {
        if (price < MINIMUM_PRICE) {
            throw new IllegalArgumentException(INVALID_ITEM_PRICE.getMessage());
        }
        if (price % PRICE_UNIT != 0) {
            throw new IllegalArgumentException(INVALID_ITEM_PRICE.getMessage());
        }
    }
}
