package vendingmachine.utils;

import java.util.Arrays;
import java.util.LinkedHashMap;

import camp.nextstep.edu.missionutils.Randoms;
import vendingmachine.domain.Coin;

public class CoinGenerator {
    private static LinkedHashMap<Coin, Integer> coins = new LinkedHashMap<>();

    private static void initialize() {
        coins.clear();
        coins.put(Coin.COIN_500, 0);
        coins.put(Coin.COIN_100, 0);
        coins.put(Coin.COIN_50, 0);
        coins.put(Coin.COIN_10, 0);
    }

    public static LinkedHashMap<Coin, Integer> makeCoins(int inputMoney) {
        initialize();
        makeCoinsUntilInputMoneyIsZero(inputMoney);
        return coins;
    }

    private static void makeCoinsUntilInputMoneyIsZero(int inputMoney) {
        while (inputMoney != 0) {
            int selectedCoinValue = Randoms.pickNumberInList(Arrays.asList(500, 100, 50, 10));
            inputMoney -= makeCoin(inputMoney, selectedCoinValue);
        }
    }

    private static int makeCoin(int inputMoney, int selectedCoinValue) {
        if (inputMoney >= selectedCoinValue) {
            Coin coin = Coin.valueOf(selectedCoinValue);
            coins.put(coin, coins.get(coin) + 1);
            return selectedCoinValue;
        }
        return 0;
    }

}
