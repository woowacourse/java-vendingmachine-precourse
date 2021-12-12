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
        for (Coin coinUnit : Coin.getAllKindsOfCoinFromLargestToSmallest()) {
            int numberOfCoin = this.count(coinUnit);
            int numberToTake = coinsToTake.count(coinUnit);
            if(numberOfCoin >= numberToTake) {
                coins.put(coinUnit, numberOfCoin - numberToTake);
                continue;
            }
            coins.put(coinUnit, 0);
        }
    }

    //TEST를 위한 메서드
    public int getAmount() {
        return getAmountWithCoin500() + getAmountWithCoin100() + getAmountWithCoin50() + getAmountWithCoin10();
    }

    private void initialize() {
        coins.put(Coin.COIN_500, initialNumberOfCoin);
        coins.put(Coin.COIN_100, initialNumberOfCoin);
        coins.put(Coin.COIN_50, initialNumberOfCoin);
        coins.put(Coin.COIN_10, initialNumberOfCoin);
    }

    private int getAmountWithCoin500() {
        return coins.get(Coin.COIN_500) * Coin.COIN_500.getAmount();
    }

    private int getAmountWithCoin100() {
        return coins.get(Coin.COIN_100) * Coin.COIN_100.getAmount();
    }

    private int getAmountWithCoin50() {
        return coins.get(Coin.COIN_50) * Coin.COIN_50.getAmount();
    }

    private int getAmountWithCoin10() {
        return coins.get(Coin.COIN_10) * Coin.COIN_10.getAmount();
    }
}
