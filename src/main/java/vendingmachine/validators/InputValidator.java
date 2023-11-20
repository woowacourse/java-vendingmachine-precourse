package vendingmachine.validators;

import static java.util.regex.Pattern.compile;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final String NUMBER_MATCH_REGEX = "^[0-9]*$";
    private static final Pattern NUMBER = compile(NUMBER_MATCH_REGEX);
    private static final String NUMBERFORMAT_EXCEPTION = "정수의 범위를 벗어났습니다";
    private static final String NOT_NUMBER_EXCEPTION = "숫자0-9만 입력 가능합니다";
    private static final String EMPTY_INPUT_EXCEPTION = "사용자의 입력이 비어있습니다.";

    public static String validateInt(final String intInput) {
        isNumberPattern(intInput);
        isInIntegerRange(intInput);
        return intInput;
    }

    private static void isInIntegerRange(final String intInput) {
        try {
            Integer.parseInt(intInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBERFORMAT_EXCEPTION);
        }
    }

    private static void isNumberPattern(final String intInput) {
        Matcher matcher = NUMBER.matcher(intInput);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
        }

    }

    public static String validateString(final String stringInput) {
        isEmptyString(stringInput);
        isBlankString(stringInput);
        return stringInput;
    }

    private static void isBlankString(final String stringInput) {
        if (stringInput.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION);
        }
    }

    private static void isEmptyString(final String stringInput) {
        if (stringInput.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_EXCEPTION);
        }
    }
}
