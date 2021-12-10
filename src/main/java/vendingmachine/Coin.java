package vendingmachine;

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
        if (amount == COIN_500.getAmount()) {
            return COIN_500;
        }

        if (amount == COIN_100.getAmount()) {
            return COIN_100;
        }

        if (amount == COIN_50.getAmount()) {
            return COIN_50;
        }

        return COIN_10;
    }

    public int getAmount() {
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

}
