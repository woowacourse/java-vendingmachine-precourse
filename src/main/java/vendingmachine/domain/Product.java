package vendingmachine.domain;

import vendingmachine.util.ErrorMessage;

import static vendingmachine.util.ErrorMessage.*;

public class Product {
    private String name;
    private int price;
    private int count;

    public Product(String name, int price, int count) {
        productValidate(count);
        this.name = name;
        this.price = price;
        this.count = count;
    }

    private void productValidate(int count) {
        if(count < 0) throw new IllegalArgumentException(PRODUCT_COUNT_UNDER_ZERO.getMessage());
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

    public int sell(){
        count --;
        return price;
    }
}
