package vendingmachine;

import java.util.Arrays;
import java.util.function.UnaryOperator;

public enum Coin {
    COIN_500(500, 0, (a -> a * 500)),
    COIN_100(100, 1, (a -> a * 100)),
    COIN_50(50, 2, (a -> a * 50)),
    COIN_10(10, 3, (a -> a * 10));

    private final int amount;
    private final int index;
    private final UnaryOperator<Integer> unaryOperator;

    Coin(final int amount, final int index, UnaryOperator<Integer> unaryOperator) {
        this.amount = amount;
        this.index = index;
        this.unaryOperator = unaryOperator;
    }

    public static Coin mapCoin(int coinAmount) {
        return Arrays.stream(Coin.values()).filter(coin -> coin.amount == coinAmount).findFirst().get();
    }

    private boolean isSameIndex(int i) {
        return this.index == i;
    }

    public Integer calculate(int number) {
        return unaryOperator.apply(number);
    }
}
