package vendingmachine.model;

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

    public static Coin create(int amount) {
        if (isCoin500(amount)) {
            return COIN_500;
        }
        if (isCoin100(amount)) {
            return COIN_100;
        }
        if (isCoin50(amount)) {
            return COIN_50;
        }

        return COIN_10;
    }

    public Integer getAmount() {
        return amount;
    }

    public static List<Integer> getAmounts() {
        return Arrays.stream(values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
    }

    public int changeIntoCoins(int inputAmount) {
        return inputAmount / this.amount;
    }

    private static boolean isCoin100(int amount) {
        return amount == COIN_100.getAmount();
    }

    private static boolean isCoin50(int amount) {
        return amount == COIN_50.getAmount();
    }

    private static boolean isCoin500(int amount) {
        return amount == COIN_500.getAmount();
    }

}
