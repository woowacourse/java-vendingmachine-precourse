package vendingmachine.domain;

import vendingmachine.util.Validator;

public class Money {
    private final int money;

    public Money(int money) {
        this.money = money;
    }

    public static Money of(String string) {
        Validator.validateNumber(string);
        return new Money(Integer.parseInt(string));
    }

    public int getMoney() {
        return money;
    }

    public Money reduce(int reduce) {
        return new Money(money - reduce);
    }
}
