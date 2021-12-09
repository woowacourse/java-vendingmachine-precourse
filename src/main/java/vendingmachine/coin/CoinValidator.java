package vendingmachine.coin;

import vendingmachine.ValidatorMessage;

public class CoinValidator {
    private static final String PREFIX = ValidatorMessage.ERROR_MESSAGE;

    public static void validateAmount(String amount) {
        if (!isNumber(amount)) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.IS_POSITIVE_NUMBER_MESSAGE);
        }
        if (!isPositiveNumber(amount)) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.IS_NATURAL_NUMBER_MESSAGE);
        }
        if (!isTenfoldNumber(amount)) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.AMOUNT_TENFOLD_NUMBER_MESSAGE);
        }
    }

    public static boolean isNumber(String amount) {
        return amount.matches(ValidatorMessage.NUMBER_REGEX);
    }

    public static boolean isPositiveNumber(String amount) {
        return amount.matches(ValidatorMessage.NATURAL_NUMBER_REGEX);
    }

    public static boolean isTenfoldNumber(String amount) {
        return Integer.parseInt(amount) % 10 == 0;
    }
}
