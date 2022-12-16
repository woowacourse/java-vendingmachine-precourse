package model;

import exception.ErrorMessage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Money {

    private static final Pattern PATTERN = Pattern.compile("^[0-9]+$");

    private int amount;

    public Money(String money) {
        validateMoney(money);
        amount = Integer.parseInt(money);
    }

    public int getAmount() {
        return amount;
    }

    public void validateMoney(String money) {
        validateNumber(money);
        validateUnit(money);
    }

    public void validateUnit(String money) {
        int moneyNum = Integer.parseInt(money);
        if (isUnit(moneyNum)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NON_UNIT_ERROR_MESSAGE.getMessage());
    }

    private static boolean isUnit(int moneyNum) {
        return moneyNum % 10 == 0;
    }

    public void validateNumber(String money) {
        if (isNumber(money)) {
            return;
        }
        throw new IllegalArgumentException(ErrorMessage.NON_NUMBER_ERROR_MESSAGE.getMessage());
    }

    public boolean isNumber(String money) {
        Matcher matcher = PATTERN.matcher(money);
        return matcher.matches();
    }
}
