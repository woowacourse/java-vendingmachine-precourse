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

    // 추가 기능 구현
    public static Coin getCoinByAmount(int amount) {
        return Arrays.stream(values())
                .filter(coin -> coin.getAmount() == amount)
                .findAny()
                .orElse(null);
    }

    public int getAmount() {
        return this.amount;
    }
}
