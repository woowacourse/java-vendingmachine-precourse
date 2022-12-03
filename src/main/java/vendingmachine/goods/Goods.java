package vendingmachine.goods;

public class Goods {
    private int price;
    private int amount;

    public Goods(String[] goodsInformation){
        makeGoodsInfo(goodsInformation);
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public void deleteAmount() {
        amount--;
    }

    void makeGoodsInfo(String[] goodsInformation) {
        price = Integer.parseInt(goodsInformation[1]);
        amount = Integer.parseInt(goodsInformation[2]);
    }
}

