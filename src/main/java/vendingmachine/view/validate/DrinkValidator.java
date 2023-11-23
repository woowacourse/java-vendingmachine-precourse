package vendingmachine.view.validate;

import java.util.regex.Pattern;

import static vendingmachine.view.constants.ErrorMessage.INVALID_DRINKS_INPUT_FORMAT;
import static vendingmachine.view.constants.ErrorMessage.ONLY_KOREAN_LETTERS;
import static vendingmachine.view.constants.Regex.REGEX_DRINK_INPUT_FORMAT;
import static vendingmachine.view.constants.Regex.REGEX_ONLY_KOREAN_LETTER;

public class DrinkValidator {
    private static final Pattern DRINK_INPUT_FORMAT = Pattern.compile(REGEX_DRINK_INPUT_FORMAT);
    private static final Pattern ONLY_KOREAN_LETTER = Pattern.compile(REGEX_ONLY_KOREAN_LETTER);

    public static void checkDrinkInput(String input) {
        if (DRINK_INPUT_FORMAT.matcher(input).matches()) {
            return;
        }
        throw new IllegalArgumentException(INVALID_DRINKS_INPUT_FORMAT);
    }

    public static void checkOnlyKoreanLetter(String input) {
        if (ONLY_KOREAN_LETTER.matcher(input).matches()) {
            return;
        }
        throw new IllegalArgumentException(ONLY_KOREAN_LETTERS);
    }
}
