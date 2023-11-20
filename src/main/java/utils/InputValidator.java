package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {

    private static final String NUMBER_REG_EXP = "^[0-9]+$";
    private static final Pattern NUMBER = Pattern.compile(NUMBER_REG_EXP);

    public static void validateBlank(String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_BLANK.getErrorMessage());
        }
    }

    public static void validateIsNumeric(String input) {
        Matcher matcher = NUMBER.matcher(input);
        if (!matcher.find()) {
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_NUMERIC.getErrorMessage());
        }
    }
}
