package vendingmachine;

import java.util.Objects;

public class Product {
    private final String name;
    private final int price;
    private int quantity;

    private Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public static Product of(String name, int price, int quantity) {
        return new Product(name, price, quantity);
    }

    public int getPrice() {
        return price;
    }

    public void reduce() {
        this.quantity--;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product)o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
