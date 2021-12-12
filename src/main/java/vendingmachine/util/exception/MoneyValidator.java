package vendingmachine.util.exception;

import vendingmachine.util.Constant;

public abstract class MoneyValidator {
    public abstract void moneyValid(String money);

    protected boolean isNumeric(String money) {
        try {
            Integer.parseInt(money);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    protected boolean isRangeValid(int money, int range) {
        return money >= range;
    }

    protected boolean isUnitSplit(int money) {
        return (money % Constant.UNIT_VALUE) == Constant.REST_VALUE;
    }

    protected int toInt(String value) {
        return Integer.parseInt(value);
    }
}
