package vendingmachine;

import static vendingmachine.ErrorMessage.PRODUCT_SOLD_OUT_ERROR_MESSAGE;

public class Product {

    private String name;
    private int price;
    private int count;

    Product(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public void sell() {
        if (count <= 0) {
            throw new IllegalArgumentException(PRODUCT_SOLD_OUT_ERROR_MESSAGE.getMessage());
        }
        this.count--;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }
}
