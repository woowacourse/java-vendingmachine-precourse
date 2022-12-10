package vendingmachine.domain;

import java.util.stream.Stream;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return this.amount + "원";
    }
}
