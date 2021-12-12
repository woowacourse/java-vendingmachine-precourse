package vendingmachine.domain;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import vendingmachine.strategy.CoinCreateStrategy;

public class Coins {

    private final Map<Coin, Integer> coins;

    public Coins(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public static Coins createByMoney(Money money, CoinCreateStrategy strategy) {
        Map<Coin, Integer> coins = Coin.createEmptyCoinMap();
        while (!money.isEmpty()) {
            Coin coin = cutOffByCoin(money, strategy);
            coins.put(coin, coins.get(coin) + 1);
        }
        return new Coins(coins);
    }

    private static Coin cutOffByCoin(Money money, CoinCreateStrategy strategy) {
        try {
            return money.cutOffByCoin(strategy.createCoin());
        } catch (IllegalArgumentException e) {
            return cutOffByCoin(money, strategy);
        }
    }

    public Map<Coin, Integer> currentRemainCoins() {
        return Collections.unmodifiableMap(new TreeMap<>(coins));
    }

    public Map<Coin, Integer> changeCoins(Money money) {
        Map<Coin, Integer> changes = Coin.createEmptyCoinMap();
        for (Coin coin : coins.keySet()) {
            int coinCount = coins.get(coin);
            changes.put(coin, calculateChange(money, coin, coinCount));
        }
        return changes;
    }

    private int calculateChange(Money money, Coin coin, int coinCount) {
        if (!money.isDivisable(coin) || coinCount <= 0) {
            return 0;
        }
        money.cutOffByCoin(coin);
        return 1 + calculateChange(money, coin, coinCount - 1);
    }
}
