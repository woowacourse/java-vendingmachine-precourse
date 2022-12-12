package vendingmachine.model;

import static vendingmachine.model.Validator.validateNegative;
import static vendingmachine.model.Validator.validateNum;

public class Product {
    private final Price price;
    private int amount;

    public Product(String price, String amount) throws IllegalArgumentException {
        this.price = new Price(price);
        this.amount = validateNum(amount);
        validateNegative(this.amount);
    }

    public boolean stockIsLeft() {
        return amount > 0;
    }

    public void reduceAmount() {
        amount--;
    }

    public int getPrice() {
        return price.get();
    }
}
