package vendingmachine.domain;

public class Item {
    private final int ZERO = 0;
    private String name;
    private int price;
    private int stock;

    public Item(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getPrice() {
        return price;
    }

    public boolean isInStock() {
        return stock > ZERO;
    }

    public boolean isEnoughMoney(int money) {
        return money >= price;
    }
}
