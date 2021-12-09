package vendingmachine;

public class Product {

    private String name;

    private int price;

    private int stockQuantity;

    public Product(String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public void sell() {
        this.stockQuantity--;
    }

    public boolean isSoldOut() {
        return stockQuantity == 0;
    }

    public String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getStockQuantity() {
        return this.stockQuantity;
    }

}
