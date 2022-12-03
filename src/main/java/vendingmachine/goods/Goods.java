package vendingmachine.goods;

public class Goods {
    private int price;
    private int amount;

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(int price) {
        this.price = price;
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

    public void makeGoodsInfo(String[] goodsInformation) {
        setPrice(Integer.parseInt(goodsInformation[1]));
        setAmount(Integer.parseInt(goodsInformation[2]));
    }
}

