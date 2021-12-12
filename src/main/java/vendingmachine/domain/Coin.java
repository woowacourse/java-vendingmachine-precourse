package vendingmachine.domain;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Coin {
    COIN_500(500, value -> value / 500),
    COIN_100(100, value -> value / 100),
    COIN_50(50, value -> value / 50),
    COIN_10(10, value -> value / 10);

    private final int amount;
    private Function<Integer, Integer> calculateNeedCoin;


    Coin(final int amount, Function<Integer, Integer> calculateChange) {
        this.amount = amount;
        this.calculateNeedCoin = calculateChange;
    }

    public static int[] coinAmountList = {500, 100, 50, 10};

    public static boolean isPossible(int amount, Coin coin) {
        if (amount >= coin.amount) {
            return true;
        }
        return false;
    }

    public static List<Integer> convertAmountList(List<Coin> possibleCoinList) {
        return possibleCoinList.stream()
                .map(coin -> coin.amount)
                .collect(Collectors.toList());
    }

    public int calcalateCovertedAmount(int value) {
        return this.amount * value;
    }

    public int calculateNeedCoin(int value) {
        return calculateNeedCoin.apply(value);
    }

}
