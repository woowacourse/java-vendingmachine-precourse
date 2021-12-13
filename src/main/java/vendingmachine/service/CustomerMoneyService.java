package vendingmachine.service;

import vendingmachine.view.InputView;

import static vendingmachine.constants.SystemConstants.NO_CUSTOMER_MONEY_LEFT;

public class CustomerMoneyService {

    private int customerMoneyLeft = NO_CUSTOMER_MONEY_LEFT;

    public int getCustomerMoneyLeft() {
        return customerMoneyLeft;
    }

    public void initializeCustomerMoneyLeft() {
        this.customerMoneyLeft = InputView.getCustomerMoneyInput();
    }

    public void decreaseCustomerMoneyLeft(int moneySpent) {
        this.customerMoneyLeft -= moneySpent;
    }
}
