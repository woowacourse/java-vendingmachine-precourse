package vendingmachine.repository;

import vendingmachine.domain.Coin;

import java.util.Map;
import java.util.TreeMap;

public class MachineCoinRepository {
    private static final MachineCoinRepository instance = new MachineCoinRepository();
    private static final Map<Coin, Integer> remainCoin = new TreeMap<>();

    private MachineCoinRepository() {
    }

    public static MachineCoinRepository getInstance() {
        return instance;
    }


    public void initCoin(Map<Coin, Integer> coins) {
        coins.keySet().forEach(c -> remainCoin.put(c, coins.get(c)));
    }

    public Map<Coin, Integer> getNumOfAllCoin() {
        Map<Coin, Integer> numOfCoin = new TreeMap<>();
        remainCoin.keySet().forEach(c -> numOfCoin.put(c, remainCoin.get(c)));
        return numOfCoin;
    }

    public int getNumOfCoin(Coin coin) {
        return remainCoin.get(coin);
    }
}
