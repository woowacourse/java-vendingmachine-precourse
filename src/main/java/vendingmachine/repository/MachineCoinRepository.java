package vendingmachine.repository;

import vendingmachine.domain.Coin;

import java.util.Map;
import java.util.TreeMap;

public class MachineCoinRepository {
    private static final Map<Coin, Integer> remainCoin = new TreeMap<>();

    public static void initCoin(Map<Coin, Integer> coins) {
        coins.keySet().forEach(c-> remainCoin.put(c, coins.get(c)));
    }

    public static Map<Coin, Integer> findNumOfCoin() {
        Map<Coin, Integer> numOfCoin = new TreeMap<>();
        remainCoin.keySet().forEach(c-> numOfCoin.put(c, remainCoin.get(c)));
        return numOfCoin;
    }



}
