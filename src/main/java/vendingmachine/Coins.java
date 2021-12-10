package vendingmachine;

import java.util.HashMap;
import java.util.Map;

public class Coins {
    private static final int initialNumberOfCoin = 0;
    public Map<Coin, Integer> coins;

    public Coins() {
        this.coins = new HashMap<>();
        initialize();
    }

    public void add(Coin coinToAdd) {
        coins.computeIfPresent(coinToAdd, (coin, number) ->  number + 1);
    }

    //TEST를 위한 메서드
    public int getAmount() {
        return getCoin500() + getCoin100() + getCoin50() + getCoin10();
    }

    private void initialize() {
        coins.put(Coin.COIN_500, initialNumberOfCoin);
        coins.put(Coin.COIN_100, initialNumberOfCoin);
        coins.put(Coin.COIN_50, initialNumberOfCoin);
        coins.put(Coin.COIN_10, initialNumberOfCoin);
    }

    private int getCoin500() {
        return coins.get(Coin.COIN_500) * Coin.COIN_500.getAmount();
    }

    private int getCoin100() {
        return coins.get(Coin.COIN_100) * Coin.COIN_100.getAmount();
    }

    private int getCoin50() {
        return coins.get(Coin.COIN_50) * Coin.COIN_50.getAmount();
    }

    private int getCoin10() {
        return coins.get(Coin.COIN_10) * Coin.COIN_10.getAmount();
    }

    //test위해. 삭제 예정
    @Override
    public String toString() {
        return "Coins{" +
                "coins=" + coins +
                '}';
    }
}
