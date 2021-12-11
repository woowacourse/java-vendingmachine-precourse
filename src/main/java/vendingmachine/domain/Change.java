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
        while (totalMoney > 0) {
            int index = pickNumberInList(getCoinEnumValueList()) - 1;

            Coin coin = getCoin(index);

            Integer count = coinMap.get(coin);

            if (checkValidCoin(coin.getAmount())) {
                coinMap.put(coin, count++);
            }
        }
    }

    private boolean checkValidCoin (int coinAmount) {
        if (coinAmount <= totalMoney) {
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
