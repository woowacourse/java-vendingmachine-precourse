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

    public boolean isProduct(String productName) {
        return name.equals(productName);
    }

    public void decreaseProduct() {
        quantity -= 1;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean isSoldOut() {
        return quantity <= 0;
    }
}
