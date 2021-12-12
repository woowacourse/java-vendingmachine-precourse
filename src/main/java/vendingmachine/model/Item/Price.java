package vendingmachine.model.Item;

import vendingmachine.util.Validator;

public class Price {
    int price;

    public Price(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return Integer.toString(price);
    }
}
