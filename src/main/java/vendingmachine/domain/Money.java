package vendingmachine.domain;

import vendingmachine.exception.MoneyRangeException;

public class Money {

    private static final int MIN_MONEY = 0;
    private static final int MAX_MONEY = 1_000_000_000;
    private static final int ZERO_MONEY = 0;

    private int money;

    private Money(int money) {
        validate(money);
        this.money = money;
    }

    public static Money from(int money) {
        return new Money(money);
    }

    private static void validate(int money) {
        validateRange(money);
    }

    private static void validateRange(int money) {
        if (money < MIN_MONEY || money > MAX_MONEY) {
            throw new MoneyRangeException(MIN_MONEY, MAX_MONEY);
        }
    }

    public void useMoney(int pay) {
        if (isUseMoney(pay)) {
            this.money -= pay;
        }
    }

    public boolean isUseMoney(int money) {
        return (this.money - money) >= ZERO_MONEY;
    }
}
