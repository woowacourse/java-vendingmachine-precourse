package vendingmachine.customer;

import vendingmachine.exception.NotEnoughMoneyException;
import vendingmachine.utils.message.MoneyErrorMessage;

public class Customer {

    private int balance;

    private Customer(){}

    public static Customer fromInputAmount(int initialAmount) {
        Customer customer = new Customer();
        customer.balance = initialAmount;
        return customer;
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int amount) {
        balance += amount;
    }

    public void reduceBalance(int amount) {
        if(balance < amount) {
            throw new NotEnoughMoneyException(MoneyErrorMessage.NOT_ENOUGH_BALANCE);
        }
        balance -= amount;
    }

    public void hasPurchaseAmount(int purchaseAmount) {
        if(balance < purchaseAmount) {
            throw new NotEnoughMoneyException(MoneyErrorMessage.NOT_ENOUGH_BALANCE);
        }
    }
}