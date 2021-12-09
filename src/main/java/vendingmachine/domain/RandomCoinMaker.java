package vendingmachine.domain;

import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.constant.Condition;

public class RandomCoinMaker {
    private static final RandomCoinMaker instance = new RandomCoinMaker();
    private HashMap<Integer, Integer> coinMap = new HashMap<>();

    private RandomCoinMaker() {
    }

    public static RandomCoinMaker getInstance() {
        return instance;
    }

    public HashMap<Integer, Integer> makeCoin(Integer money) {
        ArrayList<Integer> coins = Coin.getCoins();
        while (money > Condition.MONEY_0.getNumber()) {
            int coin = Randoms.pickNumberInList(coins);
            if (money - coin >= Condition.MONEY_0.getNumber()) {
                money -= coin;
                storeCoin(coin);
            }
        }
        return coinMap;
    }

    private void storeCoin(int coin) {
        if (!coinMap.containsKey(coin)) {
            coinMap.put(coin, Condition.ONE_COIN.getNumber());
            return;
        }
        coinMap.put(coin, coinMap.get(coin) + Condition.ONE_COIN.getNumber());
    }
}
