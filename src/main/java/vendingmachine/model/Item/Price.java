package vendingmachine.model.Item;

import vendingmachine.util.validator.Validator;

public class Price {
    public static final String PRICE_NON_DIVIDABLE_EXCEPTION = "[ERROR] 가격은 10으로 나누어 떨어져야 합니다.";
    int price;

    public Price(int price) {
        validPrice(price);
        this.price = price;
    }

    private void validPrice(int price) {
        Validator.validateNonNegative(price);
        if (price % 10 != 0) {
            throw new IllegalArgumentException(PRICE_NON_DIVIDABLE_EXCEPTION);
        }
    }

    public int getAmount() {
        return this.price;
    }

    @Override
    public String toString() {
        return Integer.toString(price);
    }
}
