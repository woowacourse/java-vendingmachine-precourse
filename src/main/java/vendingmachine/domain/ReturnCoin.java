package vendingmachine.domain;

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

        if (ProductRepository.getInstance().getAllAmount() == Condition.QUANTITY_0.getNumber()) {
            return false;
        }

        return true;
    }
}
