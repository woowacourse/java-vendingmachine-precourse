package vendingmachine.utils;

public class ValidationUtil {
    public static final int MULTIPLE_STANDARD_NUMBER = 10;
    public static final int MULTIPLE_INVALID_VALUE = 0;
    public static final int MULTIPLE_REMAINDER = 0;
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_EMPTY_MESSAGE = "값을 입력해주세요.";
    public static final String ERROR_MULTIPLE_MESSAGE = MULTIPLE_STANDARD_NUMBER + "의 단위로 입력주세요.";
    public static final String ERROR_DIGIT_MESSAGE = "숫자를 입력주세요.";

    public static void checkAmount(String value) {
        checkIsEmpty(value);
        checkIsDigit(value);
        checkIsMultipleOfStandard(value);
    }

    public static void checkIsEmpty(String value) {
        if (value.isEmpty()) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_EMPTY_MESSAGE);
        }
    }

    public static void checkIsMultipleOfStandard(String value) {
        int number = Integer.parseInt(value);
        if (number == MULTIPLE_INVALID_VALUE || number % MULTIPLE_STANDARD_NUMBER != MULTIPLE_REMAINDER) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_MULTIPLE_MESSAGE);
        }
    }

    public static void checkIsDigit(String value) {
        if (!value.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(ERROR_PREFIX + ERROR_DIGIT_MESSAGE);
        }
    }
}
