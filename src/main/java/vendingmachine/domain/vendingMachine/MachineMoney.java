package vendingmachine.domain.vendingMachine;

import vendingmachine.constant.ErrorMessage;
import vendingmachine.util.NumberValidation;

public class MachineMoney extends NumberValidation {
    final static int MIN_COIN_UNIT = 10;

    private int money;

    public int getMoney() {
        return money;
    }

    public MachineMoney(String money) throws IllegalArgumentException {
        numberValidation(money);
        isCorrectAmount(money);
        this.money = Integer.parseInt(money);
    }

    private void isCorrectAmount(String money) throws IllegalArgumentException {
        if (Integer.parseInt(money) % MIN_COIN_UNIT > 0) {
            throw new IllegalArgumentException(ErrorMessage.BIGGER_THAN_MIN_COIN_UNIT.print());
        }
    }

    public void minusMoney(int num) {
        money -= num;
    }
}
