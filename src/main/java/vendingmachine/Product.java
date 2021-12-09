package vendingmachine;

public class Product {
    private String productName;
    private int price;
    private int count;

    Product(String productName, int price, int count) {
        this.productName = productName;
        this.price = price;
        this.count = count;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public int sell() {
        return --count;
    }
}
