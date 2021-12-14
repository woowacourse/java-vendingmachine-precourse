package vendingmachine.domain.coin;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CoinGenerator {

    public static CoinCombination calculatePossibleCoinCombination(int amount) {
        CoinCombination coinCombination = new CoinCombination();
        for (Coin coin : Coin.values()) {
            coinCombination.put(coin, coin.countCoin(amount));
            amount = coin.countReducedAmount(amount);
        }
        return coinCombination;
    }

    public static CoinCombination calculateChangeCoinCombination(CoinCombination vendingMachineCoinCombination, int userMoney) {
        Map<Coin, Integer> coinCombination = vendingMachineCoinCombination.getCoinCombination();
        CoinCombination changeCombination = new CoinCombination();
        for (Coin coin : coinCombination.keySet()) {
            Integer coinCount = coinCombination.get(coin);
            int changeCoinCount = 0;
            while (coinCount > 0 && userMoney > 0 && userMoney > coin.getAmount()) {
                userMoney -= coin.getAmount();
                coinCount--;
                changeCoinCount++;
            }
            changeCombination.put(coin, changeCoinCount);
        }
        return changeCombination;
    }
}
