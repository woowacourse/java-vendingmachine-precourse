package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.enums.Coin;

import java.util.*;
import java.util.Map.Entry;

public class Changes {
    private final static int DEFAULT_VALUE = 0;
    private final static int ADD_VALUE = 1;
    private final static int NO_COIN = 0;

    private Map<Coin, Integer> coinMap = new TreeMap<>();
    private int totalChanges;

    Changes(int totalChanges) {
        this.totalChanges = totalChanges;
        initCoinMap();
    }

    public void createRandomCoins() {
        int tempChanges = DEFAULT_VALUE;
        while (tempChanges != totalChanges) {
            int randomCoin = Randoms.pickNumberInList(Coin.getCoinAmountList());
            if (!isRandomCoinUnderTotalChange(tempChanges, randomCoin)) {
                continue;
            }
            tempChanges += randomCoin;
            Coin findCoin = Coin.getCoinByNumber(randomCoin);
            coinMap.put(findCoin, coinMap.get(findCoin) + ADD_VALUE);
        }
    }

    public Map<Coin, Integer> getCoinMap() {
        return coinMap;
    }

    public Map<Coin, Integer> returnChanges(int money){
        if(money == DEFAULT_VALUE){
            return null;
        }
        Map<Coin, Integer> restChanges = getRestChanges();
        List<Coin> restCoins = new ArrayList<>(restChanges.keySet());

        return calculateChanges(money, restChanges, restCoins);
    }

    private Map<Coin, Integer> calculateChanges(int money, Map<Coin, Integer> restChanges, List<Coin> restCoins) {
        Map<Coin, Integer> calChangesMap = new TreeMap<>();
        for (Coin coin : restCoins) {
            int tempQuotient = getTempQuotientCompareWithRestChanges(restChanges, money, coin);
            money -= tempQuotient * coin.getAmount();
            putQuotientOnMap(calChangesMap, coin, tempQuotient);
            if(money == DEFAULT_VALUE){
                return calChangesMap;
            }
        }
        return calChangesMap;
    }

    private void putQuotientOnMap(Map<Coin, Integer> calChangesMap, Coin coin, int tempQuotient) {
        if(tempQuotient != DEFAULT_VALUE){
            calChangesMap.put(coin, tempQuotient);
        }
    }

    private int getTempQuotientCompareWithRestChanges(Map<Coin, Integer> restChanges, int money, Coin coin) {
        int tempQuotient = money / coin.getAmount();
        if(tempQuotient > restChanges.get(coin)) {
            tempQuotient = restChanges.get(coin);
        }
        return tempQuotient;
    }

    private Map<Coin, Integer> getRestChanges(){
        Map<Coin, Integer> tempCoinMap = new TreeMap<>();
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

    private boolean isRandomCoinUnderTotalChange(int tempChanges, int randomCoin) {
        return randomCoin + tempChanges <= totalChanges;
    }

}
