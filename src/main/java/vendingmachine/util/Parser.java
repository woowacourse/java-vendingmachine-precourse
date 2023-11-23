package vendingmachine.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import vendingmachine.exception.ExceptionHandler;

import static vendingmachine.exception.ErrorCode.*;

public class Parser {
    private static final int POSITIVE_NUMBER_MINIMUM_RANGE = 1;
    public static final Pattern REGEX_COIN_PATTERN = Pattern.compile("^[1-9]+0$");
    // Default Constructor
    private Parser() {
    }

    //== Business Logic ==//
    public static int parseVMCoinInput(String coninInput) {
        INVALID_COIN_INPUT.validate(() -> hasWhitespace(coninInput));
        INVALID_COIN.validate(() -> isInvalidCoinPattern(coninInput));
        return ExceptionHandler.tryOnParseIntException(() -> Integer.parseInt(coninInput));
    }

    //== Validation Method ==//
    private static boolean hasWhitespace(String input) {
        return input.chars().anyMatch(Character::isWhitespace);
    }

    private static boolean isInvalidCoinPattern(String input) {
        return matchWithRegex(input, REGEX_COIN_PATTERN);
    }

    // == 정규표현식 제약 조건== //
    private static boolean matchWithRegex(String input, Pattern regex) {
        Matcher matcher = regex.matcher(input);
        return !matcher.matches();
    }
}
