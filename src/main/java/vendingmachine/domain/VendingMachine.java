package vendingmachine.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import vendingmachine.strategy.CoinCreateStrategy;

public class VendingMachine {

    private final Map<Coin, Integer> coins;

    public VendingMachine(Map<Coin, Integer> coins) {
        this.coins = coins;
    }

    public static VendingMachine createByMoney(Money money, CoinCreateStrategy strategy) {
        Map<Coin, Integer> coins = Coin.createEmptyCoinMap();
        while (!money.isEmpty()) {
            Coin coin = cutOffByCoin(money, strategy);
            coins.put(coin, coins.get(coin) + 1);
        }
        return new VendingMachine(coins);
    }

    private static Coin cutOffByCoin(Money money, CoinCreateStrategy strategy) {
        try {
            return money.cutOffByCoin(strategy.createCoin());
        } catch (IllegalArgumentException e) {
            return cutOffByCoin(money, strategy);
        }
    }

    public Map<Coin, Integer> currentRemainCoins() {
        return Collections.unmodifiableMap(new HashMap<>(coins));
    }
}
