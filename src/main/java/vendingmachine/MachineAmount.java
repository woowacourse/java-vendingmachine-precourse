package vendingmachine;

import utils.ErrorMessages;

public class MachineAmount {

    private static final int MINIMUM_MONEY = 100;
    private static final int DIVISIBLE_AMOUNT = 10;
    private static final int ZERO = 0;
    private final int money;

    public MachineAmount(int money) {
        validateMinimumAmount(money);
        validateDivideByTen(money);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    private void validateMinimumAmount(int amount) {
        if (amount < MINIMUM_MONEY) {
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_MINIMUM_RANGE.getErrorMessage());
        }
    }

    private void validateDivideByTen(int amount) {
        if (amount % DIVISIBLE_AMOUNT != ZERO){
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_DIVIDE_BY_TEN.getErrorMessage());
        }
    }


}
