package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashMap;
import java.util.Map;

public class Coins {
    private final Map<Coin, Integer> coins = new LinkedHashMap<>();

    public Coins(int money) {
        makeCoinsByMoney(money);
    }

    public Map<Coin, Integer> getCoins() {
        return coins;
    }

    private void makeCoinsByMoney(int money) {
        for (Coin coin : Coin.values()) {
            int coinCount = getRandomCoinCount(money, coin);
            coins.put(coin, coinCount);
            money -= coin.getAmount() * coinCount;
        }
    }

    private int getRandomCoinCount(int money, Coin coin) {
        int minCount = 0;
        int maxCount = money / coin.getAmount();

        if (coin == Coin.COIN_10) {
            minCount = maxCount;
        }

        return Randoms.pickNumberInRange(minCount, maxCount);
    }
}
