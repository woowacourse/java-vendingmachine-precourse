package vendingmachine.coin;

import java.util.HashMap;
import java.util.Map;

import vendingmachine.coin.Coin;

public class Coins {
    private static final int initialNumberOfCoin = 0;
    private Map<Coin, Integer> coins;

    public Coins() {
        this.coins = new HashMap<>();
        initialize();
    }

    public void add(Coin coinToAdd) {
        coins.computeIfPresent(coinToAdd, (coin, number) ->  number + 1);
    }

    public void add(Coin coinToAdd, int numberOfCoin) {
        coins.computeIfPresent(coinToAdd, (coin, number) ->  number + numberOfCoin);
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

    public int count(Coin coin) {
        return coins.get(coin);
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
