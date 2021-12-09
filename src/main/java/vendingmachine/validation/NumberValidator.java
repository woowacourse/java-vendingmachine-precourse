package vendingmachine.validation;

public class NumberValidator {
    private static final String NOT_NEGATIVE_INTEGER_REGEX = "[0-9]+";

    private NumberValidator() {
    }

    public static boolean isNotPositiveInteger(String value) {
        return !value.matches(NOT_NEGATIVE_INTEGER_REGEX) || value.equals("0");
    }

    public static boolean isNotMultipleOfTen(int value) {
        return value % 10 != 0;
    }
}
