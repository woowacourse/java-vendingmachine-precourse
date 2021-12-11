package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final Coin[] coins = Coin.values();
    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    private int getAmount() {
        return amount;
    }

    public static Coin getByAmount(int amount) {
        return Arrays.stream(coins)
            .filter(coin -> coin.getAmount() == amount)
            .findFirst()
            .get();
    }

    public static List<Integer> amountList() {
        return Arrays.stream(coins)
            .map(Coin::getAmount)
            .collect(Collectors.toList());
    }
}
