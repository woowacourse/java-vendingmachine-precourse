package vendingmachine;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin of(int amount) {
        for (Coin coin : values()) {
            if (coin.amount == amount) {
                return coin;
            }
        }
        throw new IllegalArgumentException("[ERROR]");
    }

    public int getAmount() {
        return this.amount;
    }

    public static List<Integer> getCoins() {
        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }

    // 추가 기능 구현
}
