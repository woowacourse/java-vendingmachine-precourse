package vendingmachine.domain.coin;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static List<Coin> getAlCoinUnitsFromLargestToSmallest() {
        return Arrays.asList(COIN_500, COIN_100, COIN_50, COIN_10);
    }

    public static List<Integer> getAllDenominations() {
        return Arrays.asList(COIN_500.amount, COIN_100.amount, COIN_50.amount, COIN_10.amount);
    }

    public static Optional<Coin> findByAmount(int amount) {
        return Coin.getAlCoinUnitsFromLargestToSmallest().stream()
                .filter(coin -> coin.amount == amount)
                .findAny();
    }

    public int getAmount() {
        return amount;
    }

    public int getAmount(int numberOfCoin) {
        return amount * numberOfCoin;
    }

    public boolean hasMoreAmount(int amountToCompare) {
        return this.getAmount() > amountToCompare;
    }
}
