package vendingmachine.domain;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    public static final ArrayList<Coin> COINS = new ArrayList<>(Arrays.asList(Coin.values()));
    public static final String PREFIX = "COIN_";

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Integer> getCoinAmounts() {
        return COINS.stream()
            .map(coin -> coin.amount)
            .collect(toList());
    }

    public static Coin parseCoin(int amount) {
        return Coin.valueOf(PREFIX + amount);
    }

    public int getAmount() {
        return amount;
    }
}