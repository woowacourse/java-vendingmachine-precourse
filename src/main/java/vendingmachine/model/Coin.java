package vendingmachine.model;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static int getMin() {
        int min = (int)Double.POSITIVE_INFINITY;
        for (Coin coin:
        Coin.values()) {
            if (coin.amount < min) {
                min = coin.amount;
            }
        }
        return min;
    }

    public static Coin getCoinByValue(int value) {
        Coin[] coins = Coin.values();
        for (Coin coin:
             coins) {
            if (coin.amount == value) {
                return coin;
            }
        }
        return null;
    }

    public int getAmount() {
        return amount;
    }

    public static List<Integer> getCoinValues() {
        List<Integer> coinValues = new LinkedList<>();
        Arrays.stream(Coin.values()).forEach(coin -> coinValues.add(coin.amount));
        return coinValues;
    }
}
