package vendingmachine.coin;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    public static Map<Coin, Integer> createRandomCoin(int money) {
        List<Integer> coinAmountList = Coin.getCoinAmountList();
        Map<Coin, Integer> coinCount = Coin.initializeCoinCountKey();

        while(money > 0) {
            int coinAmount = Randoms.pickNumberInList(coinAmountList);
            if(coinAmount <= money){
                Coin coinCountKey = findCoinName(coinAmount);
                coinCount.computeIfPresent(coinCountKey, (K, V) -> V + 1);
                money -= coinAmount;
            }
        }
        return coinCount;
    }

    private static List<Integer> getCoinAmountList() {
        List<Integer> coinAmountList = new ArrayList<>();
        for(Coin coin : Coin.values()) {
            coinAmountList.add(coin.amount);
        }
        return coinAmountList;
    }

    private static Map<Coin, Integer> initializeCoinCountKey() {
        Map<Coin, Integer> coinCount = new HashMap<>();
        for(Coin coin : Coin.values()) {
            coinCount.put(coin, 0);
        }
        return coinCount;
    }

    private static Coin findCoinName(int coinAmount) {
        for(Coin coin : Coin.values()) {
            if(coin.amount == coinAmount) {
                return coin;
            }
        }
        return null;
    }
}