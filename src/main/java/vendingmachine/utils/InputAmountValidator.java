package vendingmachine.utils;

import static vendingmachine.exception.ErrorMessage.*;

public class InputAmountValidator {
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
}
