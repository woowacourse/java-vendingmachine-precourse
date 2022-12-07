package vendingmachine.model;

import java.util.Arrays;
import vendingmachine.util.ExceptionMessage;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin from(int amount) {
        return Arrays.stream(Coin.values())
                .filter(element -> element.getAmount() == amount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_COIN_AMOUNT.getMessage()));
    }

    public int getAmount() {
        return amount;
    }
}
