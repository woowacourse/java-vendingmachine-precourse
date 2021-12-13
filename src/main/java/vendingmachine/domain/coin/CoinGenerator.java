package vendingmachine.domain.coin;


import java.util.HashMap;
import java.util.Map;

public class CoinGenerator {

    private Map<Coin, Integer> coinCombination = new HashMap<>();

    private void calculatePossibleCoinCombination(int amount) {
        for (Coin coin : Coin.values()) {
            coinCombination.put(coin, coin.countCoin(amount));
            amount = coin.countReducedAmount(amount);
        }
    }

    public Map<Coin, Integer> generate(int amount) {
        calculatePossibleCoinCombination(amount);
        return coinCombination;
    }
}
