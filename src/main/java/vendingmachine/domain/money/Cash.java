package vendingmachine.domain.money;

import vendingmachine.exception.VendingMachineException;

public class Cash implements Spendable, Comparable<Spendable>{
    private int cash;

    public Cash(int cash) {
        validateCash(cash);
        this.cash = cash;
    }

    private void validateCash(int cash) {
        if (cash < 0) {
            throw VendingMachineException.MONEY_MUST_NOT_NEGATIVE.makeException();
        }
    }

    public boolean canPurchase(Spendable price) {
        return compareTo(price) >= 0;
    }

    public void spend(Spendable price) {
        if (compareTo(price) < 0) {
            throw VendingMachineException.NOT_ENOUGH_MONEY.makeException();
        }
        this.cash -= price.getPrice();
    }

    public Money toMoney() {
        return new Money(this.cash);
    }

    @Override
    public int compareTo(Spendable o) {
        return this.getPrice() - o.getPrice();
    }

    @Override
    public int getPrice() {
        return this.cash;
    }
}
