package vendingmachine.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Coins {
    private HashMap<Coin, Integer> coins;

    public Coins(HashMap<Coin, Integer> coins) {
        this.coins = coins;
    }

    public List<Integer> coinsCount() {
        List<Integer> count = new ArrayList<>();
        count.add(getCoinCount("COIN_500"));
        count.add(getCoinCount("COIN_100"));
        count.add(getCoinCount("COIN_50"));
        count.add(getCoinCount("COIN_10"));
        return count;
    }

    private Integer getCoinCount(String coinType) {
        Integer coinCount = coins.get(Coin.valueOf(coinType));
        if (coinCount == null) {
            return 0;
        }
        return coinCount;
    }
}
