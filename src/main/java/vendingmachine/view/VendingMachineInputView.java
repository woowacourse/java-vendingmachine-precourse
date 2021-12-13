package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.util.InputGenerator;
import vendingmachine.util.ViewMessage;
import vendingmachine.util.validator.AmountValidator;
import vendingmachine.util.validator.InputValidator;
import vendingmachine.util.validator.MerchandiseValidator;

public class VendingMachineInputView {
    private InputValidator inputValidator;

    public int inputHoldingAmount() {
        inputValidator = AmountValidator.getInstance();

        while (true) {
            try {
                System.out.println(ViewMessage.INPUT_HOLDING_AMOUNT.getMessage());
                String input = readLine();
                inputValidator.validate(input);

                return InputGenerator.convertToInteger(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    public String[][] inputMerchandiseInfo() {
        inputValidator = MerchandiseValidator.getInstance();

        while (true) {
            try {
                System.out.println(ViewMessage.INPUT_MERCHANDISE_INFO.getMessage());
                String input = readLine();
                inputValidator.validate(input);

                return InputGenerator.splitMerchandiseInfo(input);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }

    private String readLine() {
        return Console.readLine();
    }
}
