package vendingmachine.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private static final Map<Integer, Coin> coinMap = new HashMap<>();

    private final int amount;

    static {
        Arrays.stream(Coin.values()).forEach(coin -> coinMap.put(coin.getAmount(), coin));
    }

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Coin findCoin(final int amount) {
        return coinMap.get(amount);
    }

    public static List<Coin> getCoinList() {
        return Arrays.stream(Coin.values())
                .sequential()
                .collect(Collectors.toList());
    }

    public static List<Integer> getCoinValues() {
        return Arrays.stream(Coin.values())
                .sequential()
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }

    public int getAmount() {
        return amount;
    }
}
