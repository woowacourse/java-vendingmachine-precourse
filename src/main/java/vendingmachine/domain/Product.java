package vendingmachine.domain;

import vendingmachine.utils.Message;

public class Product {
    private String name;
    private int price;
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

    public void subQuantity() {
        if (this.quantity == 0) {
            throw new IllegalArgumentException(Message.IS_OUT_OF_STOCK);
        }
        this.quantity -= 1;
    }

    public static boolean isZeroQuantity(Product product) {
        if (product.quantity == 0) {
            return true;
        }
        return false;
    }

}
