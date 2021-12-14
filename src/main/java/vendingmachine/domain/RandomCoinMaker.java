package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.Condition;

public class RandomCoinMaker {
    private static final RandomCoinMaker instance = new RandomCoinMaker();

    private RandomCoinMaker() {
    }

    public static RandomCoinMaker getInstance() {
        return instance;
    }

    private LinkedHashMap<Integer, Integer> init() {
        ArrayList<Integer> coins = Coin.getCoins();
        coins.sort(Comparator.reverseOrder());

        LinkedHashMap<Integer, Integer> coinMap = new LinkedHashMap<>();
        for (Integer coin : coins) {
            coinMap.put(coin, Condition.QUANTITY_0.getNumber());
        }
        return coinMap;
    }

    public LinkedHashMap<Integer, Integer> makeCoin(Integer money) {
        LinkedHashMap<Integer, Integer> coinMap = init();
        ArrayList<Integer> coins = Coin.getCoins();

        while (money > Condition.MONEY_0.getNumber()) {
            int coin = Randoms.pickNumberInList(coins);
            if (money - coin >= Condition.MONEY_0.getNumber()) {
                money -= coin;
                coinMap.put(coin, coinMap.get(coin) + Condition.ONE_COIN.getNumber());
            }
        }
        return coinMap;
    }
}
