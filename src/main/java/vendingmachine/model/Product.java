package vendingmachine.model;

import vendingmachine.validator.ProductValidator;

public class Product implements Comparable<Product> {

    private String name;
    private int price;
    private int stock;

    public Product(String name, int price, int stock) {
        ProductValidator validator = new ProductValidator();
        validator.isValidPrice(price);
        validator.isValidName(name);
        validator.isValidStock(stock);

        this.price = price;
        this.name = name;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void sell() {
        if(isAvailable()) {
            stock--;
        }
    }

    public boolean isAvailable() {
        return stock > 0;
    }

    @Override
    public int compareTo(Product o) {
        return this.price - o.price;
    }
}
