package vendingmachine.domain.products;

import java.util.Objects;

public class Product {

    private final String name;
    private final Price price;
    private final Quantity quantity;

    public Product(String name, Price price, Quantity quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product) {
            return this.name.equals(((Product) o).name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
