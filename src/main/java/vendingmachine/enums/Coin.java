package vendingmachine.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public static Coin searchWithAmount(int amount) {
        for (Coin coin : Coin.values()) {
            if(coin.amount == amount) {
                return coin;
            }
        }
        throw new IllegalArgumentException();
    }

    public static List<Integer> getAmountList() {
        List<Integer> amountList = Arrays.asList(COIN_500.amount, COIN_100.amount, COIN_50.amount, COIN_10.amount);
        return new ArrayList<>(amountList);
    }
}
