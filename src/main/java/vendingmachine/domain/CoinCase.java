package vendingmachine.domain;

import java.util.HashMap;

public class CoinCase {

    private final HashMap<Coin, Integer> holdingCoins;

    public CoinCase() {
        holdingCoins = new HashMap<Coin, Integer>();
        for (Coin coin : Coin.getCoinListDecreasingOrder()) {
            holdingCoins.put(coin, 0);
        }
    }

    public void generateCoins(final int holdingMoney) {
        int amountToGenerate = holdingMoney;
        while (amountToGenerate > 0) {
            Coin pickedCoin = Coin.pickRandomCoin(amountToGenerate);
            pushIn(pickedCoin);
            amountToGenerate -= pickedCoin.getAmount();
        }
    }

    public HashMap<Coin, Integer> getHoldingCoins() {
        return holdingCoins;
    }

    public int getHoldingAmount() {
        int totalHoldingAmount = 0;
        for (Coin coinUnit : Coin.getCoinListDecreasingOrder()) {
            totalHoldingAmount += coinUnit.getAmount() * holdingCoins.get(coinUnit);
        }
        return totalHoldingAmount;
    }

    public int getNumberOfHoldingCoins(final Coin coin) {
        return holdingCoins.get(coin);
    }

    private void pushIn(Coin coinUnit) {

        holdingCoins.put(coinUnit, holdingCoins.get(coinUnit) + 1);
    }

    public void pullOut(Coin coinUnit) {
        holdingCoins.put(coinUnit, holdingCoins.get(coinUnit) - 1);
    }
}
