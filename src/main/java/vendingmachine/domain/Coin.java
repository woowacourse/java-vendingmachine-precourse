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

    public int getAmount() {
        return this.amount;
    }

    public static List<Integer> getCoinEnumValueList() {
        List<Integer> coinList = Arrays.stream(Coin.values())
                .map(c -> (c.getAmount()))
                .collect(Collectors.toList());

        return coinList;
    }

    public static List<Coin> getCoinEnumList() {
        List<Coin> coinList = Arrays.
                stream(Coin.values()).
                collect(Collectors.toList());

        return coinList;
    }

    public static Coin valueOf(int coinValue) {
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == coinValue) {
                return coin;
            }
        }
        return null;
    }
}
