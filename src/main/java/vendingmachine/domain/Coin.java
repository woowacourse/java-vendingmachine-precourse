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

    public static List<Coin> getCoinList() {
        return Arrays.stream(Coin.values())
                .sequential()
                .collect(Collectors.toList());
    }

    public static List<Integer> getCoinValueList() {
        return Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .sequential()
                .collect(Collectors.toList());
    }

    public static List<Integer> getAvailableCoinValueList(int remainMoney) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.getAmount() <= remainMoney)
                .map(Coin::getAmount)
                .sequential()
                .collect(Collectors.toList());
    }

    public int getAmount() {
        return amount;
    }

    public static Coin getEnumCoin(int amount) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.getAmount() == amount)
                .sequential().collect(Collectors.toList()).get(0);
    }
}
