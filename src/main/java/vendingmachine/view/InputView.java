package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.validator.InputValidator;

public class InputView {
    public String getProductName() {
        return readLine();
    }

    public int getInputAmount() {
        return InputValidator.isInteger(readLine());
    }

    private String readLine() {
        return Console.readLine().trim();
    }

}
