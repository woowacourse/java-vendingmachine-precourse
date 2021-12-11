package vendingmachine.domain;

import java.util.ArrayList;
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

    public static List<Integer> getAmountOfCoins() {
        List<Integer> list = new ArrayList<>(Coin.values().length);
        Coin[] coins = Coin.values();

        for (Coin coin : coins) {
            list.add(coin.amount);
        }

        return list;
    }

    public static Coin getCoinAsAmount(int amount) {
        Coin[] coins = Coin.values();

        for (Coin coin : coins) {
            if (coin.amount == amount) {
                return coin;
            }
        }

        return null;
    }

    public static int getAmountOfCoin(Coin coin) {
        return coin.amount;
    }
}
