package view;

import camp.nextstep.edu.missionutils.Console;
import utils.InputValidator;

public class InputView {

    public static String readAmountInput() {
        String amount = Console.readLine();
        InputValidator.validateBlank(amount);
        InputValidator.validateIsNumeric(amount);
        return amount;
    }

    public static String readOrderDetails() {
        String order = Console.readLine();
        InputValidator.validateBlank(order);
        InputValidator.validateIsOrderFormat(order);
        return order;
    }
}
