package vendingmachine.service;

import vendingmachine.view.InputView;

import static vendingmachine.constants.SystemConstants.NO_CUSTOMER_MONEY_LEFT;
import static vendingmachine.utils.NumberInputValidator.validateMoneyInput;

public class CustomerMoneyService {

    private int customerMoneyLeft = NO_CUSTOMER_MONEY_LEFT;

    public int getCustomerMoneyLeft() {
        return this.customerMoneyLeft;
    }

    public void initializeCustomerMoneyLeft() {
        this.customerMoneyLeft = this.getCustomerMoneyInput();
    }

    public void decreaseCustomerMoneyLeft(int moneySpent) {
        this.customerMoneyLeft -= moneySpent;
    }

    public int getCustomerMoneyInput() {
        try {
            String input = InputView.requestCustomerMoneyInput();
            validateMoneyInput(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCustomerMoneyInput();
        }
    }
}
