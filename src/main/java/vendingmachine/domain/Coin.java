package vendingmachine.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import vendingmachine.exception.CoinNotExistAmountException;

public enum Coin {
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
        Map<Coin, Integer> coinMap = new HashMap<>();
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
            .orElseThrow(() -> new RuntimeException("최소 coin이 존재하지 않습니다."));
    }
}
