package vendingmachine.View;

import vendingmachine.constant.SystemMessage;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String printGetMachineMoneyMessage() {
        System.out.println(SystemMessage.GET_MACHINE_MONEY_MESSAGE.print());
        return Console.readLine();
    }

    public static String printGetMerchandiseMessage() {
        System.out.println(SystemMessage.GET_MERCHANDISE_MESSAGE.print());
        return Console.readLine();
    }

    public static String printGetInputMoneyMessage() {
        System.out.println(SystemMessage.GET_INPUT_MONEY_MESSAGE.print());
        return Console.readLine();
    }

    public static String printPurchaseMessage() {
        System.out.println(SystemMessage.CHOICE_MERCHANDISE_MESSAGE.print());
        return Console.readLine();
    }
}
