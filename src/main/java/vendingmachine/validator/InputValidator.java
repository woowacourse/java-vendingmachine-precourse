package vendingmachine.validator;

import static java.util.regex.Pattern.compile;
import static vendingmachine.exception.ErrorCode.INVALID_PRODUCT_FORMAT;
import static vendingmachine.exception.ErrorCode.NOT_INTEGER;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern FORMAT = compile(
            "^\\[([^\\[\\]]+,\\d+,\\d+)(;\\[([^\\[\\]]+,\\d+,\\d+)\\])*(\\])$");


    public static int isInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(NOT_INTEGER.getMessage());
        }
    }

    public static void isValidFormat(String input) {
        Matcher matcher = FORMAT.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_PRODUCT_FORMAT.getMessage());
        }
    }
}
