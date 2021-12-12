package vendingmachine.view.input;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.MoneyValidator;
import vendingmachine.constant.Input;

public class MoneyInputView {

    public int inputMoneyForMakeCoin() {
        while (true) {
            print(Input.COIN_MONEY_GUIDE_MESSAGE.getText());
            String money = Console.readLine();
            try {
                MoneyValidator moneyValidator = new MoneyValidator();
                moneyValidator.tryToInputMoneyForMakeCoin(money);
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public int inputMoneyForPurchase() {
        while (true) {
            divisionLine();
            print(Input.PURCHASE_MONEY_GUIDE_MESSAGE.getText());
            String money = Console.readLine();
            try {
                MoneyValidator moneyValidator = new MoneyValidator();
                moneyValidator.tryInputMoneyForPurchase(money);
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void print(String message) {
        System.out.println(message);
    }

    private void divisionLine() {
        System.out.println();
    }
}