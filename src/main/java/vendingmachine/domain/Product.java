package vendingmachine.domain;

public class Product {

    private String productName;
    private int price;
    private int quantity;

    public Product(String productName, int price, int quantity) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void reduceQuantity() {
        quantity = quantity - 1;
    }
}
