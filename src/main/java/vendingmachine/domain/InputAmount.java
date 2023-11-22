package vendingmachine.domain;

import vendingmachine.constants.Constants;

public class InputAmount {

    private static final int MIN_INPUT_AMOUNT = 10;
    private static final int INPUT_AMOUNT_UNIT = 10;

    private int amount;

    public InputAmount(int amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(int amount) {
        if (amount < MIN_INPUT_AMOUNT) {
            throw new IllegalArgumentException(
                    String.format("%s 투입 금액은 %d원 이상이어야 합니다.", Constants.ERROR_PREFIX, MIN_INPUT_AMOUNT));
        }
        if (amount % INPUT_AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException(
                    String.format("%s 투입 금액은 %d원 단위만 가능합니다.", Constants.ERROR_PREFIX, INPUT_AMOUNT_UNIT));
        }
    }

    public void decrease(int amount) {
        this.amount -= amount;
    }

    public int getAmount() {
        return amount;
    }
}
