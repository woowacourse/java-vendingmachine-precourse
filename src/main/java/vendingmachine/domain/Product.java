package vendingmachine.domain;

public class Product {
    private final int price;
    private final String name;
    private int quantity;

    public Product(final String name, final int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}
