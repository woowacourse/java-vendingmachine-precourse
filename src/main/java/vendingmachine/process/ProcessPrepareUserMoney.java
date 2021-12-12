package vendingmachine.process;

import vendingmachine.user.User;
import vendingmachine.user.UserMoneyValidation;

public class ProcessPrepareUserMoney {
    public static String money;

    public static void inputUserMoney() {
        money = User.inputMoney();
    }

    public static void checkUserMoney() {
        UserMoneyValidation.checkUserMoneyValidation(money);
    }
}
