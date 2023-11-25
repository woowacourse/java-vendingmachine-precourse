package domain;

import util.CoinGenerator;

public class CoinCountGenerator implements CoinGenerator {

    @Override
    public int generateRandomCoins(Coin coin, int amount) {
        int coinCount = 0;
        while (amount >= coin.getAmount()) {
            amount -= coin.getAmount();
            coinCount++;
        }
        return coinCount;
    }
}
