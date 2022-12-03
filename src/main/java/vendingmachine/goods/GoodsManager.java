package vendingmachine.goods;

import java.util.HashMap;

public class GoodsManager {

    private HashMap<String, Goods> goodsInfo = new HashMap<String, Goods>();
    private int minPrice = Integer.MAX_VALUE;

    public void makeGoodsList(String goodsList) {
        String[] subList = goodsList.split(";");
        String[] goodsInformation;

        for (String item : subList) {
            item = item.replace("[", "").replace("]", "");
            goodsInformation = item.split(",");

            Goods goods = new Goods();
            goods.makeGoodsInfo(goodsInformation);
            goodsInfo.put(goodsInformation[0], goods);
        }
        minPriceGoodsList();
    }

    public void minPriceGoodsList() {
        for (Goods g : goodsInfo.values())
            if (g.getPrice() < minPrice) minPrice = g.getPrice();
    }

    public int purchaseGoods(String purchaseGoods, int money) {
        Goods goods = goodsInfo.get(purchaseGoods);
        if (goods.getAmount() != 0)
            goods.deleteAmount();
        return money -= goods.getPrice();
    }

    public boolean validPurchase(String purchaseGoods, int money) {
        Goods goods = goodsInfo.get(purchaseGoods);
        return goods.getPrice() < money && goods.getAmount() != 0;
    }

    public boolean validMinPurchase(int money) {
        return money >= minPrice;
    }

}
