package vendingmachine.process;

import vendingmachine.goods.GoodsController;
import vendingmachine.user.User;
import vendingmachine.user.UserGoodsNameValidation;

public class ProcessUserBuyGoods {
    // 반복해서 투입 금액 받아서 물건 사기
    // 투입 금액 예외처리 - ProcessPrepareUserMoney
    // 상품명 받으면 예외처리
    // README.md 에서 상품 구매 관련 상품 기능 구현
    // 인자로 goods list 받아서 상품 개수 줄이기
    //

    public static int userMoney;
    public static String goods;

    public static void makeUserMoney() {
        ProcessPrepareUserMoney.inputUserMoney();
        ProcessPrepareUserMoney.checkUserMoney();
        userMoney = ProcessPrepareUserMoney.toIntegerUserMoney();
    }

    public static void inputGoodsName() {
        goods = User.inputGoods();
        UserGoodsNameValidation.checkGoodsNameValidation(goods);
    }

    public static int sellGoods(GoodsController goodsController) {
        userMoney = goodsController.sellGoods(goods, userMoney);
        return userMoney;
    }
}
