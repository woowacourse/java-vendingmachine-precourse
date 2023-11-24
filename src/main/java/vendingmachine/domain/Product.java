package vendingmachine.domain;

import java.util.Comparator;

public class Product {
    private final int price;
    private final int quantity;

    private Product(int price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public static Product create(int price, int quantity) {
        return new Product(price, quantity);
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
