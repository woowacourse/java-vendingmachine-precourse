package vendingmachine.process;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.user.User;
import vendingmachine.user.UserGoodsValidation;
import vendingmachine.user.UserMoneyValidation;

public class ProcessPrepare {
    public static String holdingAmount;
    public static String goods;

    public static void inputHoldingAmount() {
        holdingAmount = User.inputMoney();
    }

    public static void checkHoldingAmount() {
        UserMoneyValidation.checkUserMoneyValidation(holdingAmount);
    }

    public static int toIntegerHoldingAmount() {
        return Integer.parseInt(holdingAmount);
    }

    public static void inputGoods() {
        goods = User.inputGoods();
    }

    public static void checkGoods() {
        UserGoodsValidation.checkUserGoodsValidation(goods);
    }

    public static void removeBracket() {
        goods.replace(ProcessConstant.SQUARE_BRACKETS_OPEN, "");
        goods.replace(ProcessConstant.SQUARE_BRACKETS_CLOSE, "");
    }
}
