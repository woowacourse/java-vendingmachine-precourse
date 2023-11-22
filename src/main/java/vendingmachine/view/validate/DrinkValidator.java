package vendingmachine.view.validate;

import java.util.regex.Pattern;

import static vendingmachine.view.constants.ErrorMessage.INVALID_DRINKS_INPUT_FORMAT;
import static vendingmachine.view.constants.Regex.REGEX_DRINK_INPUT_FORMAT;

public class DrinkValidator {
    private static final Pattern DRINK_INPUT_FORMAT = Pattern.compile(REGEX_DRINK_INPUT_FORMAT);

    public static void checkDrinkInput(String input) {
        if (DRINK_INPUT_FORMAT.matcher(input).matches()) {
            return;
        }
        throw new IllegalArgumentException(INVALID_DRINKS_INPUT_FORMAT);
    }
}
