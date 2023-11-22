package vendingmachine;

import java.math.BigDecimal;

public class Product {

    private String name;
    private BigDecimal price;
    private int quantity;

    public Product(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void decreaseQuantity() {
        this.quantity--;
    }
}
