package vendingmachine;

import static vendingmachine.ErrorMessage.PRODUCT_SOLD_OUT_ERROR_MESSAGE;

public class Product {

    private String name;
    private int price;
    private int quantity;

    Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public void sell() {
        if (quantity <= 0) {
            throw new IllegalArgumentException(PRODUCT_SOLD_OUT_ERROR_MESSAGE.getMessage());
        }
        this.quantity--;
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
}
