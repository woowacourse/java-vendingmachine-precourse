package vendingmachine.domain;

import java.util.Comparator;

public class Product {
    private final String name; //TODO: 필요 있을까? 중복된다
    private final int price;
    private final int quantity;

    private Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Product create(String name, int price, int quantity) {
        return new Product(name, price, quantity);
    }

    public static Comparator<Product> priceComparator() {
        return Comparator.comparingInt(Product::getPrice);
    }

    public int getRemainStock() {
        return this.quantity - 1;
    }

    public boolean hasStock() {
        return quantity > 0;
    }

    public int getPrice() {
        return price;
    }
}
