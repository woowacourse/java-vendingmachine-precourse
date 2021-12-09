package vendingmachine.inputvalue;

import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_WRONG_COIN_BALANCE_INPUT;
import static vendingmachine.StringConstants.MINIMUM_VALUE_OF_COIN_BALANCE;

public class CoinBalanceInputValue {
    public final String input;

    public CoinBalanceInputValue(String input) {
        this.input = input;
    }

    public int toCoinBalance() {
        try {
            int coinBalance = Integer.parseInt(input);
            validate(coinBalance);
            return coinBalance;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_COIN_BALANCE_INPUT);
        }
    }

    private void validate(int coinBalance) {
        if(coinBalance < MINIMUM_VALUE_OF_COIN_BALANCE || coinBalance % MINIMUM_VALUE_OF_COIN_BALANCE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_COIN_BALANCE_INPUT);
        }
    }
}
