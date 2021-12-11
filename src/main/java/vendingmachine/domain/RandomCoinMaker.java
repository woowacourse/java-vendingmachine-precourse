package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.Condition;

public class RandomCoinMaker {
    private static final RandomCoinMaker instance = new RandomCoinMaker();
    private LinkedHashMap<Integer, Integer> coinMap = new LinkedHashMap<>();

    private RandomCoinMaker() {
    }

    public static RandomCoinMaker getInstance() {
        return instance;
    }

    private void init() {
        ArrayList<Integer> coins = Coin.getCoins();
        coins.sort(Comparator.reverseOrder());

        for (Integer coin : coins) {
            coinMap.put(coin, 0);
        }
    }

    public void makeCoin(Integer money) {
        init();
        ArrayList<Integer> coins = Coin.getCoins();
        while (money > Condition.MONEY_0.getNumber()) {
            int coin = Randoms.pickNumberInList(coins);
            if (money - coin >= Condition.MONEY_0.getNumber()) {
                money -= coin;
                storeCoin(coin);
            }
        }
    }

    public LinkedHashMap<Integer, Integer> getCoinMap() {
        return coinMap;
    }

    private void storeCoin(int coin) {
        coinMap.put(coin, coinMap.get(coin) + Condition.ONE_COIN.getNumber());
    }
}
