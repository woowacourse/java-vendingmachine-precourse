package vendingmachine.dto.request;

import static vendingmachine.StringConstants.ERROR_MESSAGE_ABOUT_WRONG_COIN_BALANCE_INPUT;
import static vendingmachine.StringConstants.MINIMUM_VALUE_OF_COIN_BALANCE;

public class CoinBalanceRequest {
    public final String input;

    public CoinBalanceRequest(String input) {
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
        if (coinBalance < MINIMUM_VALUE_OF_COIN_BALANCE || coinBalance % MINIMUM_VALUE_OF_COIN_BALANCE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_COIN_BALANCE_INPUT);
        }
    }
}
