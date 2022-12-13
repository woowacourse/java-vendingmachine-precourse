package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Machine {
    private LinkedHashMap<Coin, Integer> coins;

    public Machine() {
        this.coins = generateCoinMap();
    }

    public LinkedHashMap<Coin, Integer> getCoins() {
        return coins;
    }

    private LinkedHashMap<Coin, Integer> generateCoinMap() {
        LinkedHashMap<Coin, Integer> coinMap = new LinkedHashMap<>();
        coinMap.put(Coin.COIN_500, 0);
        coinMap.put(Coin.COIN_100, 0);
        coinMap.put(Coin.COIN_50, 0);
        coinMap.put(Coin.COIN_10, 0);
        return coinMap;

    }

    public void generateCoin(int moneyInput) {
        List<Integer> coinUnit = getCoinUnit();
        generateRandomCoin(moneyInput, coinUnit);
    }

    private void generateRandomCoin(int moneyInput, List<Integer> coinUnit) {
        while(moneyInput > 0) {
            int pickRandomNum = Randoms.pickNumberInList(coinUnit);
            Coin randomCoin = Coin.valueOf(pickRandomNum);
            if (isInputRemainingMoney(moneyInput, pickRandomNum)) continue;
            moneyInput -= pickRandomNum;
            coins.put(randomCoin, coins.get(randomCoin) + 1);
        }
    }

    private static boolean isInputRemainingMoney(int moneyInput, int pickRandomNum) {
        return moneyInput - pickRandomNum < 0;
    }

    private static List<Integer> getCoinUnit() {
        List<Integer> coinUnit = new ArrayList<>();
        coinUnit.add(500);
        coinUnit.add(100);
        coinUnit.add(50);
        coinUnit.add(10);
        return coinUnit;
    }

}
