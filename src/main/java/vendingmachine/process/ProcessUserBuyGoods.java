package vendingmachine.process;

import vendingmachine.goods.GoodsController;
import vendingmachine.user.User;
import vendingmachine.user.UserGoodsNameValidation;

public class ProcessUserBuyGoods {
    public static String goods;

    public static boolean checkCanBuy(GoodsController goodsController, int userMoney) {
        return goodsController.isMoneyMoreThanCheapest(userMoney) && goodsController.isQuantityMoreThanOne();
    }

    public static void inputGoodsName() {
        goods = User.inputGoods();
        UserGoodsNameValidation.checkGoodsNameValidation(goods);
    }

    public static void existsGoodsName(GoodsController goodsController) {
        goodsController.existGoodsName(goods);
    }

    public static int sellGoods(GoodsController goodsController, int userMoney) {
        userMoney = goodsController.sellGoods(goods, userMoney);
        return userMoney;
    }
}
