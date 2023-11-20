package vendingmachine;

import utils.ErrorMessages;

public class InputAmount {

    private static final int ZERO = 0;
    private int money;

    public InputAmount(int money) {
        validateNegative(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public void subtractMoney(int subtractAmount) {
        validateNegative(subtractAmount);
        money -= subtractAmount;
    }

    private void validateNegative(int money) {
        if (money < ZERO) {
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_NEGATIVE.getErrorMessage());
        }
    }
}
