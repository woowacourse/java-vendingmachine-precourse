package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static String INPUT_VENDINGMACHINE_SENETENCE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    public int inputVendingmachineChange() {
        System.out.println(INPUT_VENDINGMACHINE_SENETENCE);
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
