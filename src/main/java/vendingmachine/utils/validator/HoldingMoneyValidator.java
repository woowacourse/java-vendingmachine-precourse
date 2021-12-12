package vendingmachine.utils.validator;

public class HoldingMoneyValidator {

    public static int getValidHoldingMoney(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
