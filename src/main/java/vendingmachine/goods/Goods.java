package vendingmachine.goods;

public class Goods {
    public String name;
    public String price;
    public String quantity;

    public Goods(String name, String price, String quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void reduceQuantity() {
        this.quantity = String.valueOf(Integer.parseInt(quantity) - 1);
    }
}
