package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final Validator validator = new Validator();
    private static final Printer printer = new Printer();

    public int inputMoney() {
        try {
            String money = Console.readLine();
            validator.validateMoney(money);

            return Integer.parseInt(money);
        } catch (IllegalArgumentException exception) {
            printer.printException(exception);

            return inputMoney();
        }
    }

    public String inputProductInfos() {
        try {
            String input = Console.readLine();
            validator.validateProductInfosInput(input);

            return input;
        } catch (IllegalArgumentException exception) {
            printer.printException(exception);

            return inputProductInfos();
        }
    }

    public String inputProductName() {
        try {
            String input = Console.readLine();
            validator.validateProductNameInput(input);

            return input;
        } catch (IllegalArgumentException exception) {
            printer.printException(exception);

            return inputProductName();
        }
    }
}
