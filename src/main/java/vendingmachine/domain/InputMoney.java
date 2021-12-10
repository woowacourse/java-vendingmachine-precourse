package vendingmachine.domain;

import vendingmachine.util.NumberValidation;

public class InputMoney extends NumberValidation {
    private int inputMoney;

    public InputMoney(String inputMoney) {
        numberValidation(inputMoney);
        this.inputMoney = Integer.parseInt(inputMoney);
    }
}
