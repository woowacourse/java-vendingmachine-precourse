package vendingmachine.view.input;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Condition;
import vendingmachine.constant.Input;

public class MoneyInputView {

    public int inputMoneyForMakeCoin() {
        while (true) {
            print(Input.COIN_MONEY_GUIDE_MESSAGE.getText());
            String money = Console.readLine();
            try {
                tryToInputMoneyForMakeCoin(money);
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public int inputMoneyForPurchase() {
        while (true) {
            print(Input.PURCHASE_MONEY_GUIDE_MESSAGE.getText());
            String money = Console.readLine();
            try {
                tryInputMoneyForPurchase(money);
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private void tryToInputMoneyForMakeCoin(String money) throws IllegalArgumentException {
        validateCoinMoneyDigit(money);
        validateCoinMoneyBlank(money);
    }

    private void tryInputMoneyForPurchase(String money) throws IllegalArgumentException {
        validatePurchaseMoneyDigit(money);
        validatePurchaseMoneyBlank(money);
    }

    private void validateCoinMoneyDigit(String money) {
        for (int m = 0; m < money.length(); m++) {
            if (!Character.isDigit(money.charAt(m))) {
                print(Input.COIN_MONEY_DIGIT_ERROR_MESSAGE.getText());
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateCoinMoneyBlank(String money) {
        if (money.length() == Condition.LENGTH_0.getNumber()) {
            print(Input.COIN_MONEY_LENGTH_0_ERROR_MESSAGE.getText());
            throw new IllegalArgumentException();
        }
    }

    private void validatePurchaseMoneyDigit(String money) {
        for (int m = 0; m < money.length(); m++) {
            if (!Character.isDigit(money.charAt(m))) {
                print(Input.PURCHASE_MONEY_DIGIT_ERROR_MESSAGE.getText());
                throw new IllegalArgumentException();
            }
        }
    }

    private void validatePurchaseMoneyBlank(String money) {
        if (money.length() == Condition.LENGTH_0.getNumber()) {
            print(Input.PURCHASE_MONEY_LENGTH_0_ERROR_MESSAGE.getText());
            throw new IllegalArgumentException();
        }
    }

    private void print(String message) {
        System.out.println(message);
    }
}