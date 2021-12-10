package vendingmachine.domain;

import java.util.Map;
import java.util.TreeMap;

public class CoinCount {
    private final Map<Coin, Integer> coinCount = new TreeMap<>();

    public CoinCount(int inputMoneyOfVendingMachine) {
        createRandomCoinList(inputMoneyOfVendingMachine);
    }

    public Map<Coin, Integer> getCoinCount() {
        return coinCount;
    }

    private void createRandomCoinList(int vendingMachineMoney) {
        for (Coin coinName : Coin.values()) {
            coinCount.put(coinName, 0);
        }

        Integer randomCoin;
        while (vendingMachineMoney != 0) {
            randomCoin = Coin.getRandomAmount();
            if (randomCoin <= vendingMachineMoney) {
                vendingMachineMoney -= randomCoin;
                Coin randomCoinName = findCoinByValue(randomCoin);
                coinCount.replace(randomCoinName, coinCount.get(randomCoinName) + 1);
            }
        }
    }

    private Coin findCoinByValue(int coinValue) {
        for (Coin coin : Coin.values()) {
            if (coin.getAmount() == coinValue) {
                return coin;
            }
        }
        return null;
    }
}
