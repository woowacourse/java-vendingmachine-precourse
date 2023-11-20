package vendingmachine;

import vendingmachine.message.ExceptionMessage;

public class Money {
    private int amount;

    public Money(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_FORMAT);
        }
    }

    public boolean isMoreOrEqualThen(int amount) {
        return this.amount >= amount;
    }

    public boolean isLessThen(int amount) {
        return this.amount < amount;
    }

    public void minus(int amount) {
        if (this.amount - amount < 0) {
            throw new IllegalArgumentException(ExceptionMessage.LACK_MONEY);
        }
        this.amount -= amount;
    }

    public int getAmount() {
        return amount;
    }
}
