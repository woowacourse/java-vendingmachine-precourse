package vendingmachine.products;

public class Product {
    private String name;
    private int price;
    private int counts;

    public Product(String name, int price, int counts) {
        this.name = name;
        this.price = price;
        this.counts = counts;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCounts() {
        return counts;
    }
}
