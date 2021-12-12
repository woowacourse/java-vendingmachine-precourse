package vendingmachine.domain;

import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

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

    private void pushIn(Coin coinUnit) {
        holdingCoins.put(coinUnit, holdingCoins.get(coinUnit) + 1);
    }
}
