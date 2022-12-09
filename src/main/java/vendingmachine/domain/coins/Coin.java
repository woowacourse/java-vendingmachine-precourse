package vendingmachine.domain.coins;

import vendingmachine.domain.Money;
import vendingmachine.exception.CoinEmptyException;

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

    public static Coin of(int amount) {
        return Arrays.stream(values())
                .filter(coin -> coin.amount == amount)
                .findAny()
                .orElseThrow(CoinEmptyException::new);
    }

    public static List<Integer> makeAmountList() {
        return Arrays.stream(values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }

    public static int findMinAmount() {
        return Arrays.stream(values())
                .mapToInt(Coin::getAmount)
                .min()
                .orElseThrow(CoinEmptyException::new);
    }



    public int getAmount() {
        return amount;
    }
}
