package vendingmachine;

import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
    }

    // 추가 기능 구현
    public static HashMap<Integer, Integer> randomGenerate(int money) {
        ArrayList<Integer> coinKeys = coinKeys();
        HashMap<Integer, Integer> randomCoins = new HashMap<>();
        while (money != 0) {
            int pickedCoin = Randoms.pickNumberInList(coinKeys);
            if (pickedCoin <= money) {
                int count = randomCoins.getOrDefault(pickedCoin, 0);
                randomCoins.put(pickedCoin, count+1);
                money -= pickedCoin;
            }
        }
        return randomCoins;
    }

    private static ArrayList<Integer> coinKeys() {
        ArrayList<Integer> coinKeys = new ArrayList<>();
        for (Coin coin : Coin.values()) {
            coinKeys.add(coin.amount);
        }
        return coinKeys;
    }
}
