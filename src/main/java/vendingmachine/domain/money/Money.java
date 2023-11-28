package vendingmachine.domain.money;

import vendingmachine.exception.VendingMachineException;

public class Money implements Spendable, Comparable<Spendable> {
    private final int money;

    public Money(int money) {
        validateMoney(money);
        this.money = money;
    }

    private void validateMoney(int money) {
        if (money < 0) {
            throw VendingMachineException.MENU_AMOUNT_MUST_POSITIVE.makeException();
        }
    }

    public Cash toCash(){
        return new Cash(this.money);
    }

    @Override
    public int compareTo(Spendable o) {
        return this.getPrice() - o.getPrice();
    }

    @Override
    public int getPrice() {
        return this.money;
    }
}
