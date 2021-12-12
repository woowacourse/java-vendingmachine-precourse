package vendingmachine.dto.request;

import static vendingmachine.StringConstants.*;

public class CoinBalanceRequest {
    private static final int MINIMUM_VALUE_OF_COIN_BALANCE = 10;
    private static final int MINIMUM_COIN_UNIT = 10;
    public final String input;

    public CoinBalanceRequest(String input) {
        this.input = input;
    }

    public int toCoinBalance() {
        try {
            int coinBalance = Integer.parseInt(input);
            validate(coinBalance);
            return coinBalance;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_ABOUT_WRONG_CURRENT_BALANCE_INPUT);
        }
    }

    private void validate(int coinBalance) {
        if (coinBalance < MINIMUM_VALUE_OF_COIN_BALANCE || coinBalance % MINIMUM_COIN_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }
}
