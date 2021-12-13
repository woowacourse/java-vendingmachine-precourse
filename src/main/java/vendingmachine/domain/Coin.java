package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500, 0),
    COIN_100(100, 0),
    COIN_50(50, 0),
    COIN_10(10, 0);

    private final int amount;
    private int count;

    Coin(final int amount, int count) {
        this.amount = amount;
        this.count = count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void add(int inputMachineMoney) {
        Coin[] coins = Coin.values();
        for (Coin coin : coins) {
            int quotient = inputMachineMoney / coin.amount;
            inputMachineMoney %= coin.amount;
            coin.setCount(quotient);
        }
    }

    public static List<Coin> get() {
        return Arrays.stream(Coin.values())
            .collect(Collectors.toList());
    }

    public static int getTotal() {
        return Arrays.stream(Coin.values())
            .mapToInt(Coin::getSubTotal)
            .sum();
    }

    private static int getSubTotal(Coin coin) {
        return coin.amount * coin.count;
    }
}
