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
        if (ProductRepository.getInstance().getMinCost() > money) {
            return false;
        }

        if (ProductRepository.getInstance().getMinCost() == Condition.NOTHING.getNumber()) {
            return false;
        }

        if (ProductRepository.getInstance().getAllAmount() == Condition.QUANTITY_0.getNumber()) {
            return false;
        }

        return true;
    }

    public LinkedHashMap<Integer, Integer> calcReturnChangeToCoin(int money) {
        LinkedHashMap<Integer, Integer> coinMap = RandomCoinMaker.getInstance().getCoinMap();

        LinkedHashMap<Integer, Integer> changeCoinMap = new LinkedHashMap<>();
        for (Integer coin : coinMap.keySet()) {
            if (coinMap.get(coin) <= Condition.QUANTITY_0.getNumber()) {
                continue;
            }
            if (money / coin > Condition.QUOTIENT_1.getNumber()) {
                int number = moveCoin(money, coin);
                changeCoinMap.put(coin, number);
            }
        }
        return changeCoinMap;
    }

    private int moveCoin(int money, int coin) {
        LinkedHashMap<Integer, Integer> coinMap = RandomCoinMaker.getInstance().getCoinMap();
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
