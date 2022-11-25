package vendingmachine;

import static vendingmachine.MessageUtils.MONEY_INPUT_ERROR;

public class Money {
    private final int amount;

    public Money(String amount) {
        if (!isValidMoney(amount)) {
            throw new IllegalArgumentException(MONEY_INPUT_ERROR.msg());
        }
        this.amount = Integer.parseInt(amount);
    }

    private boolean isValidMoney(String amount) {
        if (!isNull(amount) && isNumeric(amount)) {
            return true;
        }
        return false;
    }

    private boolean isNull(String amount) {
        return amount.isBlank();
    }

    private boolean isNumeric(String amount) {
        return amount.chars().allMatch(Character::isDigit);
    }

}
