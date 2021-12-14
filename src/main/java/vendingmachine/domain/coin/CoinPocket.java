package vendingmachine.domain.coin;

import vendingmachine.domain.coin.provider.CoinProvider;
import vendingmachine.util.CoinChange;

import java.util.EnumSet;

public class CoinPocket {
    private EnumSet<Coin> coins;

    public static CoinPocket getInstance() {
        return new CoinPocket();
    }

    private CoinPocket() {
        coins = Coin.getSet();
    }

    public int putCoinAndAddCount(int machineBalance, CoinProvider coinProvider) {
        int amount = coinProvider.drawCoinLessThanBalance(machineBalance);
        Coin coin = Coin.getCoinEquals(amount);

        if (isNoCoinInPocket(coin)) {
            coins.add(coin);
        }
        coin.addCount();

        return amount;
    }

    private boolean isNoCoinInPocket(Coin coin) {
        return !coins.contains(coin);
    }

    public void makeCoinCountMin(int changeAmount) {
        CoinChange.makeCoinsCountMin(coins, changeAmount);
    }

    // for test
    public int countEachCoin(Coin coin) {
        return coin.getCount();
    }
}
