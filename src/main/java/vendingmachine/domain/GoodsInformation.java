package vendingmachine.domain;

public class GoodsInformation {
    private final int price;
    private int stock;

    public GoodsInformation(int price, int stock) {
        this.price = price;
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
    public void decreaseStockByOne() {
        stock -= 1;
    }
}
