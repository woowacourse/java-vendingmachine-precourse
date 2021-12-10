package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.Validator;

public class InputView {
    private static String INPUT_VENDINGMACHINE_SENETENCE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    private final Validator validator;

    public InputView() {
        this.validator = new Validator();
    }

    public int inputVendingmachineChange() {
        System.out.println(INPUT_VENDINGMACHINE_SENETENCE);
        String input = Console.readLine();
        try {
            validator.isValidVendingmachineChange(input);
            return Integer.parseInt(input);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputVendingmachineChange();
        }
    }
}
