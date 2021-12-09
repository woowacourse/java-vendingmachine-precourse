package vendingmachine.domain;

import java.util.Arrays;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public static Coin valueOf(int amount) {
        return Arrays.stream(Coin.values())
            .filter(coin -> coin.getAmount() == amount)
            .findAny().orElseThrow(() -> new IllegalArgumentException("존재하지 않는 동전입니다."));
    }

}
