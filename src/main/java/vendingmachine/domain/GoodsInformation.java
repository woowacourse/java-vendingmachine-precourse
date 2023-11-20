package vendingmachine.domain;

public class GoodsInformation {
    private final int price;
    private int quantity;

    public GoodsInformation(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
