package vendingmachine;

import utils.ErrorMessages;

public class Product {
    private final String name;
    private final int price;
    private int quantity;

    public Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void decreaseQuantity() {
        quantity--;
        if (quantity < 0) {
            throw new IllegalArgumentException(ErrorMessages.VALIDATE_NEGATIVE_QUANTITY.getErrorMessage());
        }
    }
}