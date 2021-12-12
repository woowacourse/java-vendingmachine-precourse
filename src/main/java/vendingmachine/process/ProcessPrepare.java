package vendingmachine.process;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.user.User;

public class ProcessPrepare {
    public static String holdingAmount;

    public static void inputHoldingAmount() {
        holdingAmount = User.inputMoney();
    }

}
