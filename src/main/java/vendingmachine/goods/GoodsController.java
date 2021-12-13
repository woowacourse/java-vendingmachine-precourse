package vendingmachine.goods;

import java.util.ArrayList;
import java.util.List;

public class GoodsController {
    List<Goods> goodsList;

    GoodsController(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public boolean checkGoodsName(Goods goods, String name) {
        return goods.name == name;
    }

    public boolean checkQuantity(Goods goods) {
        return goods.quantity > 0;
    }

    public boolean checkMoney(Goods goods, int userMoney) {
        return goods.price <= userMoney;
    }

    public boolean checkAvailablePurchase(Goods goods, String name, int userMoney) {
        return checkGoodsName(goods, name) && checkQuantity(goods) && checkMoney(goods, userMoney);
    }

    public void sellGoods(String name, int userMoney) {
        for (Goods goods : goodsList) {
            if (checkAvailablePurchase(goods, name, userMoney)) {
                goods.reduceQuantity();
                return;
            }
        }
    }

    public boolean isQuantityMoreThanOne() {
        int totalQuantity = 0;

        for (Goods goods : goodsList) {
            totalQuantity += goods.getQuantity();
            if(totalQuantity >= 1) {
                return true;
            }
        }
        return false;
    }
}
