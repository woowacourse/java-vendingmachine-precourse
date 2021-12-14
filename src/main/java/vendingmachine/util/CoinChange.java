package vendingmachine.util;

import vendingmachine.domain.coin.Coin;

import java.util.Set;

public class CoinChange {
    public static void makeCoinsCountMin(Set<Coin> coins, int changeAmount) {
        for(Coin coin : coins) {
            changeAmount = isCoinLessThanAmount(coin, changeAmount);
        }
    }

    private static int isCoinLessThanAmount(Coin coin, int changeAmount) {
        while(coin.isPossible(changeAmount)) {
            changeAmount = coin.reduceChangeAsCoinAmount(changeAmount);
        }
        return changeAmount;
    }
}
