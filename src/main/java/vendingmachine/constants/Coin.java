package vendingmachine.constants;

import java.util.Arrays;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int value;

    Coin(final int value) {
        this.value = value;
    }

    public static Coin getCoinByValue(int value) {
        return Arrays.stream(values())
                .filter(coin -> coin.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getValue() {
        return value;
    }
}
