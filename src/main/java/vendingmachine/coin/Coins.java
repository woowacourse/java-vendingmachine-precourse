package vendingmachine.coin;

import java.util.HashMap;
import java.util.Map;

public class Coins {
    private static final int initialNumberOfCoin = 0;
    private final Map<Coin, Integer> coins = new HashMap<>();

    public Coins() {
        initialize();
    }

    public void add(Coin coinToAdd) {
        coins.computeIfPresent(coinToAdd, (coin, number) -> number + 1);
    }

    public void add(Coin coinToAdd, int numberOfCoin) {
        coins.computeIfPresent(coinToAdd, (coin, number) -> number + numberOfCoin);
    }

    public int count(Coin coin) {
        return coins.get(coin);
    }

    public void take(Coins coinsToTake) {
        for (Coin coinUnit : Coin.getAlCoinUnitsFromLargestToSmallest()) {
            int numberOfCoin = this.count(coinUnit);
            int numberToTake = coinsToTake.count(coinUnit);
            if (numberOfCoin >= numberToTake) {
                coins.put(coinUnit, numberOfCoin - numberToTake);
                continue;
            }
            coins.put(coinUnit, 0);
        }
    }

    public boolean hasSmallerOrEqualAmount(int amountToCompare) {
        if (getAmount() <= amountToCompare) {
            return true;
        }
        return false;
    }

    public int getAmount() {
        int totalAmount = 0;
        for (Coin coinUnit : Coin.getAlCoinUnitsFromLargestToSmallest()) {
            totalAmount += coinUnit.getAmount(this.count(coinUnit));
        }
        return totalAmount;
    }

    private void initialize() {
        coins.put(Coin.COIN_500, initialNumberOfCoin);
        coins.put(Coin.COIN_100, initialNumberOfCoin);
        coins.put(Coin.COIN_50, initialNumberOfCoin);
        coins.put(Coin.COIN_10, initialNumberOfCoin);
    }
}
