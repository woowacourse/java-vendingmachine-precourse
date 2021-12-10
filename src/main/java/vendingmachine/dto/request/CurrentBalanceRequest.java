package vendingmachine.dto.request;

import static vendingmachine.StringConstants.*;

public class CurrentBalanceRequest {
    private static final int MINIMUM_VALUE_OF_CURRENT_BALANCE = 10;
    private static final int MINIMUM_CURRENCY_UNIT = 10;
    public final String input;

    public CurrentBalanceRequest(String input) {
        this.input = input;
    }

    public int toCurrentBalance() {
        try {
            int currentBalance = Integer.parseInt(input);
            validate(currentBalance);
            return currentBalance;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_CURRENT_BALANCE_INPUT);
        }
    }

    private void validate(int coinBalance) {
        if (coinBalance < MINIMUM_VALUE_OF_CURRENT_BALANCE || coinBalance % MINIMUM_CURRENCY_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_CURRENT_BALANCE_INPUT);
        }
    }
}
