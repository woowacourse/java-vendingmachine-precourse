package vendingmachine.domain;

import vendingmachine.constants.Constants;

public class VendingMachineAmount {

    private static final int MIN_AMOUNT = 10;
    private static final int AMOUNT_UNIT = 10;

    private int amount;

    public VendingMachineAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < MIN_AMOUNT) {
            throw new IllegalArgumentException(
                    String.format("%s 자판기가 보유 금액은 %d원 이상이어야 합니다.",
                            Constants.ERROR_PREFIX.getValue(), MIN_AMOUNT));
        }
        if (amount % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(
                    String.format("%s 자판기가 보유 금액은 %d원 단위만 가능합니다.",
                            Constants.ERROR_PREFIX.getValue(), MIN_AMOUNT));
        }
    }

    public boolean isGreaterThanZero() {
        return amount > 0;
    }

    public boolean isLessThan(int amount) {
        return this.amount < amount;
    }

    public void decrease(int amount) {
        this.amount -= amount;
    }
}
