package vendingmachine.process;

import vendingmachine.goods.Goods;
import vendingmachine.user.*;

import java.util.ArrayList;
import java.util.List;

public class ProcessPrepareGoods {
    public static String goods;
    public static List<String[]> goodsArray = new ArrayList<>();

    public static void makeGoods() {
        inputGoods();
        checkGoods();
        removeBracket();
        toArray();
        toGoodsArray();
        checkGoodsEachValidation();
    }

    public static void clearList() {
        goodsArray.clear();
    }

    public static void inputGoods() {
        goods = User.inputGoods();
    }

    public static void checkGoods() {
        UserGoodsValidation.checkUserGoodsValidation(goods);
    }

    public static void removeBracket() {
        goods = goods.replace(ProcessConstant.SQUARE_BRACKETS_OPEN, "");
        goods = goods.replace(ProcessConstant.SQUARE_BRACKETS_CLOSE, "");
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

    public static void checkGoodsEachValidation() {
        for (String[] goods : goodsArray) {
            UserGoodsNameValidation.checkGoodsNameValidation(goods[0]);
            UserGoodsPriceValidation.checkGoodsPriceValidation(goods[1]);
            try {
                UserGoodsQuantityValidation.checkGoodsQuantityValidation(goods[2]);
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new IllegalArgumentException(InputErrorConstant.ERROR_QUANTITY_IS_NULL);
            }
        }
    }

    public static List<Goods> produceGoods() {
        List<Goods> goodsList = new ArrayList<>();

        for (String[] oneGoods : goodsArray) {
            Goods stuff = new Goods(oneGoods[0], Integer.parseInt(oneGoods[1]), Integer.parseInt(oneGoods[2]));
            goodsList.add(stuff);
        }

        return goodsList;
    }

}
