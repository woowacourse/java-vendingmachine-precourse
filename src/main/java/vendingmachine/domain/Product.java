package vendingmachine.domain;

public class Product {
    private String name;
    private Price price;
    private Quantity quantity;

    private Product(String name, Price price, Quantity quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Product registerProduct(String name, Price price, Quantity quantity) {
        return new Product(name, price, quantity);
    }

    public String getName() {
        return name;
    }
}
