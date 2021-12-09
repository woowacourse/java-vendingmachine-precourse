package vendingmachine.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class CoinGenerator {
    private static LinkedHashMap<Coin, Integer> coins = new LinkedHashMap<>();

    public static LinkedHashMap<Coin, Integer> makeCoins(int inputMoney) {
        initialize();
        putCoinsUntilMoneyIsZero(inputMoney);
        return coins;
    }

    private static void putCoinsUntilMoneyIsZero(int inputMoney) {
        while (inputMoney != 0) {
            int coinValue = Randoms.pickNumberInList(Arrays.asList(500, 100, 50, 10));
            inputMoney = putCoins(inputMoney, coinValue);
        }
    }

    private static void initialize() {
        coins.clear();
        coins.put(Coin.COIN_500, 0);
        coins.put(Coin.COIN_100, 0);
        coins.put(Coin.COIN_50, 0);
        coins.put(Coin.COIN_10, 0);
    }

    private static int putCoins(int inputMoney, int coinValue) {
        if (inputMoney >= coinValue) {
            inputMoney -= coinValue;
            Coin coin = Coin.valueOf(coinValue);
            coins.put(coin, coins.get(coin) + 1);
        }
        return inputMoney;
    }

}
