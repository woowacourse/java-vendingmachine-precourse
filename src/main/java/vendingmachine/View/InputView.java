package vendingmachine.View;

import vendingmachine.constant.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String printSetMachineMoneyMessage() {
        System.out.println(SystemMessage.PRINT_SET_MACHINE_MONEY_MESSAGE.print());
        return Console.readLine();
    }

    public static String printSetMerchandiseMessage() {
        System.out.println(SystemMessage.PRINT_SET_MERCHANDISE_MESSAGE.print());
        return Console.readLine();
    }
}
