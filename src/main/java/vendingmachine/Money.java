package vendingmachine;

import util.Validator;

public class Money {
    private int money;

    public Money(int money) {
        Validator.validateDivisibleByMinimumMonetaryUnit(money);
        this.money = money;
    }
}
