package vendingmachine.customer;

import vendingmachine.exception.NotEnoughMoneyException;
import vendingmachine.utils.message.MoneyErrorMessage;

public class Customer {

    private int amount;

    private Customer(){}

    public static Customer fromInputAmount(int initialAmount) {
        Customer customer = new Customer();
        customer.amount = initialAmount;
        return customer;
    }

    public int getAmount() {
        return amount;
    }

    public void addAmount(int amount) {
        this.amount += amount;
    }

    public void reduceAmount(int amount) {
        if(this.amount < amount) {
            throw new NotEnoughMoneyException(MoneyErrorMessage.NOT_ENOUGH_MONEY);
        }
        this.amount += amount;
    }

    public void hasPurchaseAmount(int purchaseAmount) {
        if(amount < purchaseAmount) {
            throw new NotEnoughMoneyException(MoneyErrorMessage.NOT_ENOUGH_MONEY);
        }
    }
}