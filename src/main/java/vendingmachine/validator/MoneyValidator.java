package vendingmachine.validator;

import vendingmachine.constant.Condition;
import vendingmachine.constant.Input;

public class MoneyValidator {

    public void tryToInputMoneyForMakeCoin(String money) throws IllegalArgumentException {
        validateCoinMoneyDigit(money);
        validateCoinMoneyBlank(money);
        validateMultipleOfTen(money);
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

    private void validateMultipleOfTen(String money) {
        if (Integer.parseInt(money) % Condition.DIVIDE_NUMBER.getNumber() != Condition.REMAINDER_0.getNumber()) {
            print(Input.MONEY_DIVIDE_ERROR_MESSAGE.getText());
            throw new IllegalArgumentException();
        }
    }

    public void tryInputMoneyForPurchase(String money) throws IllegalArgumentException {
        validatePurchaseMoneyDigit(money);
        validatePurchaseMoneyBlank(money);
        validateMultipleOfTen(money);
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
