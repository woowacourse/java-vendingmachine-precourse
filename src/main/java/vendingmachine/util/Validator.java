package vendingmachine.util;

public class Validator {
    public static final String NOT_INTEGER_EXCEPTION = "[ERROR] 숫자를 입력해주세요.";

    public static void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_EXCEPTION);
        }
    }
}
