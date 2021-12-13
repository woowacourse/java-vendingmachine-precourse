package vendingmachine.domain;

import java.util.LinkedHashMap;

import vendingmachine.constant.Condition;

public class ReturnCoin {
    private static final ReturnCoin instance = new ReturnCoin();

    private ReturnCoin() {
    }

    public static ReturnCoin getInstance () {
        return instance;
    }

    public boolean canReturn(int money) {
        if (!ProductRepository.getInstance().hasAllProductQuantity()) {
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
                int number = moveCoin(coinMap, money, coin);
                changeCoinMap.put(coin, number);
            }
        }
        return changeCoinMap;
    }

    private int moveCoin(LinkedHashMap<Integer, Integer> coinMap, int money, int coin) {
        int coinQuantityLimit = coinMap.get(coin);
        int coinUsing = Condition.QUANTITY_0.getNumber();

        while (coinQuantityLimit > Condition.QUANTITY_0.getNumber()) {
            if (money / coin < Condition.QUOTIENT_1.getNumber()) {
                break;
            }
            money -= coin;
            coinQuantityLimit -= Condition.QUANTITY_1.getNumber();
            coinUsing += Condition.QUANTITY_1.getNumber();
        }
        return coinUsing;
    }
}
