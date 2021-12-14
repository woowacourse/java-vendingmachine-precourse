package vendingmachine.domain.coin;

import vendingmachine.domain.coin.util.CoinProvider;
import vendingmachine.util.CoinChange;

import java.util.Set;
import java.util.TreeSet;

public class CoinPocket {
    private Set<Coin> coins;

    public static CoinPocket getInstance() {
        return new CoinPocket();
    }
    private CoinPocket() {
        coins = new TreeSet<>();
    }

    public int putCoinAndAddCount(int machineBalance, CoinProvider coinProvider) {
        int amount = coinProvider.drawCoinLessThanBalance(machineBalance);
        Coin coin = Coin.getCoinWithAmountInput(amount);

        if(isNoCoinInPocket(coin)) {
            coins.add(coin);
        }

        coin.addCount();
        return amount;
    }

    private boolean isNoCoinInPocket(Coin coin) {
        return !coins.contains(coin);
    }

    // for test
    public int countEachCoin(Coin coin) {
        return coin.getCount();
    }

    // for test
    protected int getAllCoinsSum() {
        return coins.stream().mapToInt(coin -> coin.multiplyAmountAndCount()).sum();
    }

    public void makeCoinCountMin(int changeAmount) {
        CoinChange.makeCoinsCountMin(coins, changeAmount);
    }
}
