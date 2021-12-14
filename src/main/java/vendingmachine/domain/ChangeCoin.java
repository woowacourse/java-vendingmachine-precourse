package vendingmachine.domain;

import java.util.LinkedHashMap;

import vendingmachine.constant.Condition;

public class ChangeCoin {
    private static final ChangeCoin instance = new ChangeCoin();

    private ChangeCoin() {
    }

    public static ChangeCoin getInstance () {
        return instance;
    }

    public boolean canReturnChange(int money) {
        if (!ProductRepository.getInstance().hasProductQuantityAtLeastOne()) {
            return false;
        }

        if (!ProductRepository.getInstance().isMinCost(money)) {
            return false;
        }
        return true;
    }

    public LinkedHashMap<Integer, Integer> calcReturnChangeToCoin(LinkedHashMap<Integer, Integer> coinMap, int money) {
        LinkedHashMap<Integer, Integer> changeCoinMap = new LinkedHashMap<>();
        for (Integer coin : coinMap.keySet()) {
            if (coinMap.get(coin) <= Condition.QUANTITY_0.getNumber()) {
                continue;
            }
            if (money / coin > Condition.QUOTIENT_1.getNumber()) {
                int number = usingNextCoin(coinMap, money, coin);
                changeCoinMap.put(coin, number);
            }
        }
        return changeCoinMap;
    }

    private int usingNextCoin(LinkedHashMap<Integer, Integer> coinMap, int money, int coin) {
        int coinQuantityUsingLimit = coinMap.get(coin);
        int coinUsing = Condition.QUANTITY_0.getNumber();

        while (coinQuantityUsingLimit > Condition.QUANTITY_0.getNumber()) {
            if (money / coin < Condition.QUOTIENT_1.getNumber()) {
                break;
            }
            money -= coin;
            coinQuantityUsingLimit -= Condition.QUANTITY_1.getNumber();
            coinUsing += Condition.QUANTITY_1.getNumber();
        }
        return coinUsing;
    }
}
