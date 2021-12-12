package vendingmachine.domain;

import java.util.HashMap;
import java.util.Map;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInList;
import static vendingmachine.domain.Coin.*;

public class Change {

    private Map<Coin, Integer> coinMap = new HashMap<>();
    private int totalMoney;

    public Change(int money) {
        this.totalMoney = money;
        initCoinMap();
    }

    public void createCoin() {
        int auxiliaryMoney = this.totalMoney;

        while (auxiliaryMoney > 0) {
            int coinValue = pickNumberInList(getCoinEnumValueList());

            Coin coin = valueOf(coinValue);

            Integer count = coinMap.get(coin);

            if (checkValidCoin(coin.getAmount(), auxiliaryMoney)) {
                count = count +1;
                coinMap.put(coin, count);

                auxiliaryMoney = auxiliaryMoney - coin.getAmount();
            }
        }
    }

    public Map<Coin, Integer> getCoinMap() {
        return coinMap;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    private boolean checkValidCoin (int coinAmount, int auxiliaryMoney) {
        if ((coinAmount <= auxiliaryMoney) && (auxiliaryMoney - coinAmount >= 0)) {
            return true;
        }

        return false;
    }

    private void initCoinMap() {
        coinMap.put(COIN_10, 0);
        coinMap.put(COIN_50, 0);
        coinMap.put(COIN_100, 0);
        coinMap.put(COIN_500, 0);
    }
}
