package vendingmachine.domain;

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

    // 추가 기능 구현
    public static List<Integer> amounts() {
        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }

    public static Coin getCoinWithValue(int amount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.getAmount() == amount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("No coin matched value = " + amount));
    }

    public int getAmount() {
        return amount;
    }
}
