package vendingmachine.process;

import vendingmachine.user.User;
import vendingmachine.user.UserMoneyValidation;

public class ProcessPrepareUserMoney {
    public static String money;

    public static int makeUserMoney() {
        inputUserMoney();
        checkUserMoney();
        return toIntegerUserMoney();
    }

    public static void inputUserMoney() {
        money = User.inputMoney();
    }

    public static void checkUserMoney() {
        UserMoneyValidation.checkUserMoneyValidation(money);
    }

    public static int toIntegerUserMoney() {
        return Integer.parseInt(money);
    }
}
