package vendingmachine.utils.validator;

public class NumberValidator {

    public static int getValidNumber(final String input, final String errorMessage) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateNotExceedMaxValue(final int input, final int maxValue, final String errorMessage) {
        if (input > maxValue) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static void validateNotExceedMinValue(final int input, final int minValue, final String errorMessage) {
        if (input < minValue) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
