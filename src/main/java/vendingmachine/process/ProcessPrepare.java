package vendingmachine.process;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.user.User;
import vendingmachine.user.UserMoneyValidation;

public class ProcessPrepare {
    public static String holdingAmount;

    public static void inputHoldingAmount() {
        holdingAmount = User.inputMoney();
    }

    public static void checkHoldingAmount() {
        UserMoneyValidation.checkUserMoneyValidation(holdingAmount);
    }
}
