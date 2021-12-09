package vendingmachine.machine;

import camp.nextstep.edu.missionutils.Console;

public class MachineController {
    private static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";

    private final Machine machine;

    public MachineController() {
        machine = new Machine(initInputMoney());
    }

    public int initInputMoney() {
        int inputMoney = 0;
        try {
            System.out.println(INPUT_MONEY_MESSAGE);
            String clientInput = Console.readLine();
            // 검증 로직
            inputMoney = Integer.parseInt(clientInput);
        } catch (IllegalArgumentException e) {
            initInputMoney();
        }
        return inputMoney;
    }
}
