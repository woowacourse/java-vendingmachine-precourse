package vendingmachine.util;

public class Validator {
    public static final String NOT_INTEGER_EXCEPTION = "[ERROR] 숫자를 입력해주세요.";
    public static final String NOT_POSITIVE_NUMBER_EXCEPTION = "[ERROR] 0이상의 숫자를 입력해주세요.";

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION);
        }
    }
    public static void validateNonNegative(int input) {
        if (input < 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_EXCEPTION);
        }
    }

}
