package vendingmachine.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;
import vendingmachine.exception.CoinNotExistAmountException;
import vendingmachine.exception.CoinNotFoundLeastException;

public enum Coin implements Comparator<Coin> {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Integer> currentCoinAmounts() {
        return Arrays.stream(values())
            .map(coin -> coin.amount)
            .collect(Collectors.toList());
    }

    public static Coin valueOfAmount(int amount) {
        return Arrays.stream(values())
            .filter(coin -> coin.amount == amount)
            .findFirst()
            .orElseThrow(CoinNotExistAmountException::new);
    }

    public static Map<Coin, Integer> createEmptyCoinMap() {
        Map<Coin, Integer> coinMap = new TreeMap<>();
        Arrays.stream(values())
            .forEach(coin -> coinMap.put(coin, 0));
        return coinMap;
    }

    public int amount() {
        return amount;
    }

    public static int leastCoin() {
        return Arrays.stream(values())
            .min(Comparator.comparingInt(Coin::amount))
            .map(Coin::amount)
            .orElseThrow(CoinNotFoundLeastException::new);
    }

    @Override
    public int compare(Coin o1, Coin o2) {
        return o2.amount - o1.amount;
    }
}
