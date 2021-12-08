package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.enums.Coin;
import vendingmachine.utils.ExceptionMessage;

import java.util.*;

class Changes {
    private final static int DEFAULT_VALUE = 0;
    private final static int ADD_VALUE = 1;

    private Map<Coin, Integer> coinMap = new HashMap<>();
    private int totalChange;

    public Changes(String input) {
        this.totalChange = validateChange(input);
        initCoinMap();

    }

    public void createRandomCoins(){
        int tempChange = 0;
        while (tempChange != totalChange){
            int randomCoin = Randoms.pickNumberInList(Coin.getCoinAmountList());
            if(!isRandomCoinUnderTotalChange(tempChange, randomCoin)){
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
        coinMap.put(Coin.COIN_500, 0);
        coinMap.put(Coin.COIN_100, 0);
        coinMap.put(Coin.COIN_50, 0);
        coinMap.put(Coin.COIN_10, 0);
    }

    private int validateChange(String input){
        int change = isNumber(input);
        isDivideByTen(change);
        return change;
    }

    private boolean isRandomCoinUnderTotalChange(int tempChange, int randomCoin) {
        return randomCoin + tempChange <= totalChange;

    }

    private void isDivideByTen(int change) {
        if(change % Coin.COIN_10.getAmount() != 0){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_PRICE_NOT_DIVIDE_BY_TEN);
        }
    }

    private int isNumber(String input) {
        try{
           return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.ERROR_PREFIX + ExceptionMessage.ERROR_PRICE_NOT_NUMBER);
        }
    }
}
