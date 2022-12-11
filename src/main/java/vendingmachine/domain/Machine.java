package vendingmachine.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Machine {
    /**
     * 자판기 클래스에서는 필요한게 보유하고 있는 금액을 받는다.
     * 받고 나서 랜덤으로 생성한 동전의 데이터만 갖고 있다.
     * 그렇다면 코인은 List로 존재하여야 한다.
     */
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

    /**
     * 자판기가 갖고 있는 돈을 인자로 받아서
     * 코인을 하나씩 랜덤으로 생성한다.
     * 랜덤으로 생성한 돈이 현재 보유한 돈 보다 크면 다시 시도한다.
     * 보유한 돈이 0이되면 그만한다.
     * @param moneyInput
     */
    public void generateCoin(int moneyInput) {
        List<Integer> coinUnit = getCoinUnit();
        while(moneyInput > 0) {
            int pickRandomNum = Randoms.pickNumberInList(coinUnit);
            Coin randomCoin = Coin.valueOf(pickRandomNum);
            if (moneyInput - pickRandomNum < 0) {
                continue;
            }
            moneyInput -= pickRandomNum;
            coins.put(randomCoin, coins.get(randomCoin) + 1);
        }
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
