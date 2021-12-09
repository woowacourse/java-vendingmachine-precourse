package vendingmachine.machine;

import camp.nextstep.edu.missionutils.Console;

public class MachineInputView {
    private static final String INPUT_MONEY_MESSAGE = "투입 금액을 입력해 주세요.";

    public static String initInputMoneyByClient(){
        System.out.println();
        System.out.println(INPUT_MONEY_MESSAGE);
        return Console.readLine();
    }
}
