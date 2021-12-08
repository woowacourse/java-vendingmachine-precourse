package vendingmachine.domain;

import vendingmachine.View.OutputView;
import vendingmachine.constant.ErrorMessage;

public class MachineMoney {
    final static int MIN_COIN_UNIT = 10;

    private int money;

    public MachineMoney(String money) throws IllegalArgumentException {
        machineMoneyValidation(money);
        this.money = Integer.parseInt(money);
    }

    private void machineMoneyValidation(String money) throws IllegalArgumentException {
        isDigitString(money);
        isBlank(money);
        isCorrectAmount(money);
    }

    private void isDigitString(String money) throws IllegalArgumentException {
        for (char c : money.toCharArray()) {
            isDigit(c);
        }
    }

    private void isDigit(char c) throws IllegalArgumentException {
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIGIT_MESSAGE.print());
        }
    }

    private void isBlank(String money) throws IllegalArgumentException {
        if (money.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NULL_ERROR_MESSAGE.print());
        }
    }

    private void isCorrectAmount(String money) throws IllegalArgumentException {
        if (Integer.parseInt(money) % MIN_COIN_UNIT > 0) {
            throw new IllegalArgumentException(ErrorMessage.BIGGER_THAN_MIN_COIN_UNIT.print());
        }
    }
}
