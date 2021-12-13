package vendingmachine.domain.coin;

import vendingmachine.domain.coin.Coin;

import java.util.ArrayList;
import java.util.List;

public class CoinGenerator {
    private List<Integer> coinCombination = new ArrayList<>();

    private void calculatePossibleCoinCombination(int amount) {
        while (amount > 0) {
            for (Coin coin : Coin.values()) {
                coinCombination.add(coin.countCoin(amount));
                amount = coin.countReducedAmount(amount);
            }
        }
    }

    public List<Integer> generate(int amount) {
        calculatePossibleCoinCombination(amount);
        return coinCombination;
    }
}
