package vendingmachine.process;

import camp.nextstep.edu.missionutils.Console;

import vendingmachine.user.User;
import vendingmachine.user.UserGoodsValidation;
import vendingmachine.user.UserMoneyValidation;

import java.util.List;

public class ProcessPrepare {
    public static String holdingAmount;
    public static String goods;
    public static List<String[]> goodsArray;

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

    public static String[] toArray() {
        String[] goodsArray = goods.split(ProcessConstant.GOODS_DELIMITER);
        return goodsArray;
    }

    public static void toGoodsArray() {
        String[] array = toArray();

        for (String oneGoods : array) {
            String[] goods = oneGoods.split(",");
            goodsArray.add(goods);
        }
    }
}
