package vendingmachine.domain;

public class Product {
    private final String name;
    private final int price;
    private int amount;

    public Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

}
