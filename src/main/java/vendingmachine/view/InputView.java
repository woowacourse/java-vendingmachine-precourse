package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.Util;
import vendingmachine.util.validator.MachineMoneyValidator;

public class InputView {

    private enum ConsoleMessage {
        INPUT_MACHINE_MONEY("자판기가 보유하고 있는 금액을 입력해 주세요.");

        private final String message;

        ConsoleMessage(String message) {
            this.message = message;
        }
    }

    public int readMachineMoney() {
        System.out.println(ConsoleMessage.INPUT_MACHINE_MONEY.message);
        String input = Console.readLine();
        new MachineMoneyValidator().validate(input);
        return Integer.parseInt(Util.removeSpace(input));
    }
}