package vendingmachine.goods;

import vendingmachine.user.InputErrorConstant;

import java.util.ArrayList;
import java.util.List;

public class GoodsController {
    List<Goods> goodsList;

    public GoodsController(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public boolean checkGoodsName(Goods goods, String name) {
        return name.equals(goods.getName());
    }

    public boolean checkQuantity(Goods goods) {
        return goods.getQuantity() > 0;
    }

    public boolean checkMoney(Goods goods, int userMoney) {
        return goods.price <= userMoney;
    }

    public boolean checkAvailablePurchase(Goods goods, String name, int userMoney) {
        return checkGoodsName(goods, name) && checkQuantity(goods) && checkMoney(goods, userMoney);
    }

    public int sellGoods(String name, int userMoney) {
        for (Goods goods : goodsList) {
            if (checkAvailablePurchase(goods, name, userMoney)) {
                userMoney -= goods.getPrice();
                goods.reduceQuantity();
                return userMoney;
            }
        }
        return userMoney;
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

    public boolean isCheaper(int price, int cheapest) {
        return price < cheapest;
    }

    public int isCheapest() {
        int cheapest = goodsList.get(0).getPrice();

        for (Goods goods : goodsList) {
            if (checkQuantity(goods) && isCheaper(goods.getPrice(), cheapest)) {
                cheapest = goods.getPrice();
            }
        }
        return cheapest;
    }

    public boolean isMoneyMoreThanCheapest(int userMoney) {
        return userMoney >= isCheapest();
    }

    public void existGoodsName(String goodsName) {
        for (Goods goods : goodsList) {
            if (checkGoodsName(goods, goodsName)) {
                return;
            }
        }
        throw new IllegalArgumentException(InputErrorConstant.ERROR_NOT_EXISTS_GOODS_NAME);
    }
}
