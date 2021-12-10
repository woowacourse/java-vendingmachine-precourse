package vendingmachine;

import java.util.*;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    private static List<Coin> getAllKindsOfCoin() {
        return Arrays.asList(COIN_500, COIN_100, COIN_50, COIN_10);
    }

    public static List<Integer> getAllDenominations() {
        return Arrays.asList(COIN_500.amount, COIN_100.amount, COIN_50.amount, COIN_10.amount);
    }

    public static Optional<Coin> findByAmount(int amount) {
        return Coin.getAllKindsOfCoin().stream()
                .filter(coin -> coin.amount == amount)
                .findAny();
    }

    public int getAmount() {
        return amount;
    }


}
