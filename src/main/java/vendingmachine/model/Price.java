package vendingmachine.model;

import static vendingmachine.model.Validator.validateNum;
import static vendingmachine.model.Validator.validatePrice;

public class Price {
    private final int price;
    Price(String price) {
        this.price = validateNum(price);
        validatePrice(this.price);
    }

    public int get() {
        return price;
    }
}
