package vendingmachine.process;

import vendingmachine.user.User;

public class ProcessPrepareUserMoney {
    public static String money;

    public static void inputUserMoney() {
        money = User.inputMoney();
    }
}
