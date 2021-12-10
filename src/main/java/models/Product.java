package models;

public class Product {
    private String productName;
    private int price;
    private int remains;

    public Product(String productName, int price, int remains) {
        this.productName = productName;
        this.price = price;
        this.remains = remains;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", remains=" + remains +
                '}';
    }
}