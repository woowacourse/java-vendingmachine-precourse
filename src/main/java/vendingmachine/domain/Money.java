package vendingmachine.domain;

import vendingmachine.utils.Exception;
import vendingmachine.utils.NumberValidator;

public class Money {
    private int cost;

    public Money(String cost) {
        validateInsertMoney(cost);
        this.cost = Integer.parseInt(cost);
    }

    public int getCost() {
        return cost;
    }

    public void decreaseMoney(int cost) {
        this.cost -= cost;
    }

    public boolean isAvailableForPurchase(int price) {
        return price <= cost;
    }

    private void validateInsertMoney(String price) {
        if (!NumberValidator.validateNumber(price)) {
            throw new IllegalArgumentException(Exception.NUMBER_EXCEPTION_MESSAGE);
        }
        if (!NumberValidator.checkDivideTen(price)) {
            throw new IllegalArgumentException(Exception.NUMBER_DIVIDE_TEM_EXCEPTION_MESSAGE);
        }
    }
}
