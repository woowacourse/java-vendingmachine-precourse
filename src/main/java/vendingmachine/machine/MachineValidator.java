package vendingmachine.machine;

import vendingmachine.ValidatorMessage;

public class MachineValidator {
    public static final String PREFIX = ValidatorMessage.ERROR_MESSAGE;

    public static void validateAmountNaturalNumber(String money) {
        if (!money.matches(ValidatorMessage.NUMBER_REGEX)) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.IS_NUMBER_MESSAGE);
        }
        if (Integer.parseInt(money) <= 0) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.INPUT_MONEY_NATURAL_NUMBER_MESSAGE);
        }
    }

    public static void validateMoneyEnough(int money, int price) {
        if (money < price) {
            throw new IllegalArgumentException(PREFIX + ValidatorMessage.NOT_ENOUGH_AMOUNT);
        }
    }
}
