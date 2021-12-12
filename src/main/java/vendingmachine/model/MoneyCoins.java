package vendingmachine.model;

import java.util.HashMap;
import java.util.Map;

public class MoneyCoins {
    Map<MoneyCoin, Integer> coins = new HashMap<>();

    public void add(MoneyCoin coin) {
        if (coins.containsKey(coin)) {
            coins.put(coin, coins.get(coin) + 1);
            return;
        }
        coins.put(coin, 1);
    }
}
