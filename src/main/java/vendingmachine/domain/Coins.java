package vendingmachine.domain;

import java.util.Map;

public class Coins {
    private final Map<Coin, Integer> coins;

    public Coins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public Map getCoins() {
        return this.coins;
    }

    public int getSumOfCoins() {
        return coins.entrySet().stream()
                .map(coin -> coin.getKey().getAmount() * coin.getValue())
                .reduce(0, Integer::sum);
    }
}
