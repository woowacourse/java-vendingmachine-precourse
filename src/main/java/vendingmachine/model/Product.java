package vendingmachine.model;

public class Product {
    private final String name;
    private final int price;
    private int remaining;

    public Product(String name, int price, int remaining) {
        this.name = name;
        this.price = price;
        this.remaining = remaining;
    }
}
