package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.enums.Coin;

import java.util.*;

class Changes {
    private final static int DEFAULT_VALUE = 0;
    private final static int ADD_VALUE = 1;

    private Map<Coin, Integer> coinMap = new HashMap<>();
    private int totalChange;

    public Changes(int totalChange) {
        this.totalChange = totalChange;
        initCoinMap();
    }

    public void createRandomCoins() {
        int tempChange = 0;
        while (tempChange != totalChange) {
            int randomCoin = Randoms.pickNumberInList(Coin.getCoinAmountList());
            if (!isRandomCoinUnderTotalChange(tempChange, randomCoin)) {
                continue;
            }
            tempChange += randomCoin;
            Coin findCoin = Coin.getCoinByNumber(randomCoin);
            coinMap.put(findCoin, coinMap.get(findCoin) + ADD_VALUE);
        }
    }

    public Map<Coin, Integer> getCoinMap() {
        return coinMap;
    }

    public int getTotalChange() {
        return totalChange;
    }

    private void initCoinMap() {
        coinMap.put(Coin.COIN_500, DEFAULT_VALUE);
        coinMap.put(Coin.COIN_100, DEFAULT_VALUE);
        coinMap.put(Coin.COIN_50, DEFAULT_VALUE);
        coinMap.put(Coin.COIN_10, DEFAULT_VALUE);
    }

    private boolean isRandomCoinUnderTotalChange(int tempChange, int randomCoin) {
        return randomCoin + tempChange <= totalChange;

    }

}
