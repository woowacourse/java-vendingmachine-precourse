package vendingmachine.domain;

import vendingmachine.constant.ErrorMessage;
import vendingmachine.util.NumberValidation;

public class InputMoney extends NumberValidation {
    final static String MONEY_UNIT = "원";

    private int inputMoney;

    public InputMoney(String inputMoney) {
        numberValidation(inputMoney);
        this.inputMoney = Integer.parseInt(inputMoney);
    }

    public int getInputMoney() {
        return inputMoney;
    }

    public String toString() {
        return inputMoney + MONEY_UNIT;
    }

    public void use(int price) {
        lackInputMoney(price);
        inputMoney -= price;
    }

    public void lackInputMoney(int price) throws IllegalArgumentException {
        if (inputMoney < price) {
            throw new IllegalArgumentException(ErrorMessage.LACK_MONEY.print());
        }
    }
}
