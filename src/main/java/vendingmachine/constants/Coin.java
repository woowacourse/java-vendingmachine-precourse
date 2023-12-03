package vendingmachine.constants;

import java.util.Arrays;
import java.util.EnumMap;
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

    public static EnumMap<Coin, Integer> getCoins(int money) {
        List<Coin> sorted = getSortedCoins();
        EnumMap<Coin, Integer> ret = new EnumMap<>(Coin.class);
        for (Coin c : sorted) {
            ret.put(c, money / c.amount);
            money %= c.amount;
        }
        return ret;
    }

    private static List<Coin> getSortedCoins() {
        return Arrays.stream(values())
                .sorted((l, r) -> r.amount - l.amount)
                .collect(Collectors.toList());
    }

}
