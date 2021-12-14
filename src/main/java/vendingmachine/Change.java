package vendingmachine;

import java.util.Map;

public class Change extends Coins{
    public Change(int amount, HoldingCoins holdingCoins) {
        calculateChange(amount, holdingCoins);
    }

    public Map<Coin, Integer> get() {
        return coins;
    }

    private void calculateChange(int restAmount, HoldingCoins holdingCoins) {
        for (Coin coin : holdingCoins.sortCoinsReversed()) {
            int coinCount = calculateCoinCount(restAmount, coin, holdingCoins);
            addChanges(coin, coinCount);
            restAmount = getRestMoney(restAmount, coin.getAmount(), coinCount);
        }
    }

    private void addChanges(Coin coin, int coinCount) {
        if (coinCount > ZERO) {
            coins.put(coin, coinCount);
        }
    }

    private int calculateCoinCount(int restAmount, Coin coin, HoldingCoins holdingCoins) {
        int coinCount = coin.changeIntoCoins(restAmount);

        if (!holdingCoins.hasCoin(coin)) {
            coinCount = ZERO;
        }
        if (holdingCoins.hasLessCoins(coin, coinCount)) {
            coinCount = holdingCoins.getCoinCount(coin);
        }

        return coinCount;
    }

}
