package vendingmachine.view.validate;

import java.util.regex.Pattern;

import static vendingmachine.view.constants.ErrorMessage.INVALID_VENDING_MACHINE_TOTAL_MONEY;
import static vendingmachine.view.constants.Regex.REGEX_MONEY_NUMERIC;

public class InputValidator {
    private static final Pattern NUMERIC = Pattern.compile(REGEX_MONEY_NUMERIC);

    public static void checkNumericInput(String input) {
        if (NUMERIC.matcher(input).matches()) {
            return;
        }
        throw new IllegalArgumentException(INVALID_VENDING_MACHINE_TOTAL_MONEY);
    }
}
