package vendingmachine.domain;

public class Product {
    private final String name;
    private final int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public boolean isSameNameWith(String name) {
        return this.name.equals(name);
    }

    public boolean isPriceLowerOrEqualWith(int price) {
        return this.price <= price;
    }

    public void countDownQuantity() {
        quantity--;
    }

    public boolean isEmpty() {
        return quantity <= 0;
    }

    public int getPrice() {
        return price;
    }
}
