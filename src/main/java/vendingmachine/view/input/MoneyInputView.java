package vendingmachine.view.input;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Condition;
import vendingmachine.constant.Input;

public class MoneyInputView {

    public int inputMoneyForMakeCoin() {
        while (true) {
            print(Input.MONEY_GUIDE_MESSAGE.getText());
            String money = Console.readLine();
            try {
                tryToInputMoneyForMakeCoin(money);
                return Integer.parseInt(money);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public void tryToInputMoneyForMakeCoin(String money) throws IllegalArgumentException {
        validateDigit(money);
        validateBlank(money);
    }

    private void validateDigit(String money) {
        for (int m = 0; m < money.length(); m++) {
            if (!Character.isDigit(money.charAt(m))) {
                print(Input.MONEY_DIGIT_ERROR_MESSAGE.getText());
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateBlank(String money) {
        if (money.length() == Condition.LENGTH_0.getNumber()) {
            print(Input.MONEY_LENGTH_0_ERROR_MESSAGE.getText());
            throw new IllegalArgumentException();
        }
    }

    private void print(String message) {
        System.out.println(message);
    }
}