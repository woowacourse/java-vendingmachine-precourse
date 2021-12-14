package vendingmachine.domain.coin;

import java.util.HashMap;
import java.util.Map;

public class CoinCombination {
    private final Map<Coin, Integer> coinCombination;

    public CoinCombination() {
        coinCombination = new HashMap<>();
    }

    public void put(Coin coin, Integer count) {
        coinCombination.put(coin, count);
    }

    public void print() {
        coinCombination.forEach(
                (coin, count) -> System.out.println(coin + " - " + count + "개")
        );
    }

}
