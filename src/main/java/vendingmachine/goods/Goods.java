package vendingmachine.goods;

public class Goods {
    public String name;
    public int price;
    public int quantity;

    public Goods(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void reduceQuantity() {
        this.quantity--;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getPrice() {
        return this.price;
    }
}
