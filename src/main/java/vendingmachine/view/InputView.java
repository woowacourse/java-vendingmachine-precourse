package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.util.Constants.*;

public class InputView {

    public static String enterMachineMoney() {
        System.out.println(ENTER_MACHINE_MONEY_MSG);
        return Console.readLine();
    }

    public static String enterMachineMenus() {
        System.out.println(ENTER_MACHINE_MENUS_MSG);
        return Console.readLine();
    }

    public static String enterUserMoney() {
        System.out.println(ENTER_USER_MONEY_MSG);
        return Console.readLine();
    }

    public static String enterUserPurchaseMenu() {
        System.out.println(ENTER_USER_PURCHASE_MENU);
        return Console.readLine();
    }
}
