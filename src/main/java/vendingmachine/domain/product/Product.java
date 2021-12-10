package vendingmachine.domain.product;

public class Product {

    private final String name;
    private final int price;
    private int amount;

    private Product(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }

    public static Product from(String name, int price, int amount) {
        return new Product(name, price, amount);
    }

    // for test
    public boolean verifyName(String name) {
        return this.name == name;
    }
}
