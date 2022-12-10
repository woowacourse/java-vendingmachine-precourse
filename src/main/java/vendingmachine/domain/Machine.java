package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Machine {
    /**
     * 자판기 클래스에서는 필요한게 보유하고 있는 금액을 받는다.
     * 받고 나서 랜덤으로 생성한 동전의 데이터만 갖고 있다.
     * 그렇다면 코인은 List로 존재하여야 한다.
     */
    private Product product;
    private LinkedHashMap<Coin, Integer> coins;

    public Machine(Product product) {
        this.product = product;
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

    private void generateCoin(int moneyInput) {
        List<Integer> coinUnit = new ArrayList<>();
        coinUnit.add(500);
        coinUnit.add(100);
        coinUnit.add(50);
        coinUnit.add(10);

        while(moneyInput >= 0) {
            int pickRandomNum = Randoms.pickNumberInList(coinUnit);
            if (moneyInput - pickRandomNum >= 0) {
                moneyInput -= pickRandomNum;
                coins.put(moneyInput, coins.get(moneyInput) + 1);
            }
        }
    }

}
