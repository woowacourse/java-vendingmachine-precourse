package vendingmachine.View;

import vendingmachine.constant.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String printSetMachineMoneyMessage() {
        System.out.println(SystemMessage.SET_MACHINE_MONEY_MESSAGE.print());
        return Console.readLine();
    }

    public static String printSetMerchandiseMessage() {
        System.out.println(SystemMessage.SET_MERCHANDISE_MESSAGE.print());
        return Console.readLine();
    }

    public static String printSetInputMoneyMessage() {
        System.out.println(SystemMessage.SET_INPUT_MONEY_MESSAGE.print());
        return Console.readLine();
    }
}
