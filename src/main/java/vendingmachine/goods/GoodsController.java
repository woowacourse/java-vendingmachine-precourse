package vendingmachine.goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsController {
    List<Goods> goodsList = new ArrayList<>();

    GoodsController(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public boolean checkGoodsName(Goods goods, String name) {
        return goods.name == name;
    }

    public boolean checkQuantity(Goods goods) {
        if (goods.quantity > 0) {
            return true;
        }
        return false;
    }

    public boolean checkMoney(Goods goods, int userMoney) {
        if (goods.price <= userMoney) {
            return true;
        }
        return false;
    }

    public boolean checkAvailablePurchase(Goods goods, String name, int userMoney) {
        return checkGoodsName(goods, name) && checkQuantity(goods) && checkMoney(goods, userMoney);
    }
}
