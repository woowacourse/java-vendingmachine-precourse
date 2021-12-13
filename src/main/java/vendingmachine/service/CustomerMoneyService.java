package vendingmachine.service;

import static vendingmachine.constants.SystemConstants.NO_CUSTOMER_MONEY_LEFT;

public class CustomerMoneyService {

    private int customerMoneyLeft = NO_CUSTOMER_MONEY_LEFT;

    public int getCustomerMoneyLeft() {
        return customerMoneyLeft;
    }

    public void setCustomerMoneyLeft(int moneyInput) {
        this.customerMoneyLeft = moneyInput;
    }

    public void decreaseCustomerMoneyLeft(int moneySpent) {
        this.customerMoneyLeft -= moneySpent;
    }
}
