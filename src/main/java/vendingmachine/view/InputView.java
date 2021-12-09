package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.constant.Condition;
import vendingmachine.constant.Input;

public class InputView {

    public int inputMoneyForMakeCoin() {
        while (true) {
            print(Input.MONEY_GUIDE_MESSAGE.getMessage());
            String Money = Console.readLine();
            try {
                tryToInputMoneyForMakeCoin(Money);
                return Integer.parseInt(Money);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    public void tryToInputMoneyForMakeCoin(String Money) throws IllegalArgumentException {
        validateDigit(Money);
        validateNull(Money);
    }

    private void validateDigit(String Money) {
        for (int m = 0; m < Money.length(); m++) {
            if (!Character.isDigit(Money.charAt(m))) {
                print(Input.MONEY_DIGIT_ERROR_MESSAGE.getMessage());
                throw  new IllegalArgumentException();
            }
        }
    }

    private void validateNull(String Money) {
        if (Money.length() == Condition.LENGTH_0.getNumber()) {
            print(Input.MONEY_LENGTH_0_ERROR_MESSAGE.getMessage());
            throw new IllegalArgumentException();
        }
    }

    private void print(String message) {
        System.out.println(message);
    }
}