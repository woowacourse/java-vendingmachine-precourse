package vendingmachine.process;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.user.User;
import vendingmachine.user.UserGoodsValidation;
import vendingmachine.user.UserMoneyValidation;

import java.util.List;

public class ProcessPrepareHoldingAmount {
    public static String holdingAmount;

    public static int makeHoldingAmount() {
        inputHoldingAmount();
        checkHoldingAmount();
        return toIntegerHoldingAmount();
    }

    public static void inputHoldingAmount() {
        holdingAmount = User.inputMoney();
    }

    public static void checkHoldingAmount() {
        UserMoneyValidation.checkUserMoneyValidation(holdingAmount);
    }

    public static int toIntegerHoldingAmount() {
        return Integer.parseInt(holdingAmount);
    }
}
