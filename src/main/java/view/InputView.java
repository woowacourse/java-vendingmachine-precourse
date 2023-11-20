package view;

import camp.nextstep.edu.missionutils.Console;
import utils.InputValidator;

public class InputView {

    public static String readVendingMachineMoney() {
        String amount = Console.readLine();
        InputValidator.validateBlank(amount);
        InputValidator.validateIsNumeric(amount);
        return amount;
    }
}
