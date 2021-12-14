package vendingmachine.domain;

public class Product {
    private static final int MINIMUM_QUANTITY = 1;
    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceStock() {
        if (!isExistQuantity()) {
            throw new IllegalArgumentException();
        }
        this.quantity--;
    }

    private boolean isExistQuantity() {
        return this.quantity > MINIMUM_QUANTITY;
    }
}
