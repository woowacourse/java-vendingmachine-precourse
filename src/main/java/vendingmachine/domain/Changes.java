package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.enums.Coin;

import java.util.*;
import java.util.Map.Entry;

public class Changes {
    private final static int DEFAULT_VALUE = 0;
    private final static int ADD_VALUE = 1;
    private final static int NO_COIN = 0;

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

    public Map<Coin, Integer> returnChanges(int money){
        Map<Coin, Integer> restChanges = getRestChanges();
        List<Coin> restCoins = new ArrayList<>(restChanges.keySet());

        Collections.sort(restCoins);

        calculateChanges(money, restChanges, restCoins);
        return restChanges;
    }

    private void calculateChanges(int money, Map<Coin, Integer> restChanges, List<Coin> restCoins) {
        for (Coin coin : restCoins) {
            int tempCount = money / coin.getAmount();
            if(tempCount > restChanges.get(coin)) {
                tempCount = restChanges.get(coin);
            }
            restChanges.replace(coin, tempCount);
        }
    }

    private Map<Coin, Integer> getRestChanges(){
        Map<Coin, Integer> tempCoinMap = new HashMap<>();
        for (Entry<Coin, Integer> coinEntry : coinMap.entrySet()) {
            if (coinEntry.getValue() > NO_COIN){
                tempCoinMap.put(coinEntry.getKey(), coinEntry.getValue());
            }
        }
        return tempCoinMap;
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
