package vendingmachine.domain;

public class Product {

    private String name;
    private int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }

    public boolean isPriceGreaterThan(int amount) {
        return price > amount;
    }

    public boolean isSoldOut() {
        return quantity == 0;
    }
}
