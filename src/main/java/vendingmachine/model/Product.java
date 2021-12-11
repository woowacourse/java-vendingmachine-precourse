package vendingmachine.model;

public class Product {
    private String name;
    private int price;
    private int stock;

    public Product(String[] productInfo) {
        this.name = productInfo[0];
        this.price = Integer.parseInt(productInfo[1]);
        this.stock = Integer.parseInt(productInfo[2]);
    }
}
