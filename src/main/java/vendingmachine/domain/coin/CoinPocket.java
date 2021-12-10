package vendingmachine.domain.coin;

import vendingmachine.Coin;
import vendingmachine.domain.coin.util.CoinProvider;

import java.util.HashMap;
import java.util.Map;

public class CoinPocket {
    private Map<Coin, Integer> coins;

    public CoinPocket() {
        coins = new HashMap<>();
    }

    public int putCoinAndAddCount(int machineBalance, CoinProvider coinProvider) {
        int amount = coinProvider.drawCoinLessThanBalance(machineBalance);
        Coin coin = Coin.getCoinWithAmountInput(amount);

        coins.put(coin, coins.getOrDefault(coin, 0) + 1);

        return amount;
    }

    // for test
    public int countEachCoin(Coin coin) {
        return coins.get(coin);
    }

    // for test
    protected int getAllCoinsSum() {
        int sum = 0;
        for (Coin coin : coins.keySet()) {
            System.out.println(coin.getAmount());
            sum += coin.getAmountSum(coins.get(coin));
        }
        return sum;
    }
}
