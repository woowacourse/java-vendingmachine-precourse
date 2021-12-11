package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coins {
    Map<MoneyCoin, Integer> coins = new HashMap<>();

    public void addCoin(MoneyCoin coin) {
        if (coins.containsKey(coin)) {
            coins.put(coin, coins.get(coin) + 1);
            return;
        }
        coins.put(coin, 1);
    }
}
