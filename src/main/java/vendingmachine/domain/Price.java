package vendingmachine.domain;

import static vendingmachine.Constant.*;
import static vendingmachine.ErrorMessage.*;

public class Price {
    private int price;

    public Price(String priceInput) {
        this.price = validate(priceInput);
    }

    public int validate(String priceInput) {
        int price = validateItIsNumber(priceInput);
        validateItIsPositive(price);
        validateUnitIsCorrect(price);
        return price;
    }

    private void validateUnitIsCorrect(int price) {
        if (price % MINIMUM_COIN_VALUE != ZERO) {
            throw new IllegalArgumentException(PRICE_UNIT_ERROR_MESSAGE);
        }
    }

    private void validateItIsPositive(int price) {
        if (price < ZERO) {
            throw new IllegalArgumentException(PRICE_RANGE_ERROR_MESSAGE);
        }
    }

    private int validateItIsNumber(String priceInput) {
        if (!priceInput.matches(NUMBER_REGEX)) {
            throw new IllegalArgumentException(PRICE_NOT_NUMBER_ERROR_MESSAGE);
        }
        return Integer.parseInt(priceInput);
    }

    public int getPrice() {
        return price;
    }

    public void use(int productPrice) {
        this.price -= productPrice;
    }

    @Override
    public String toString() {
        return Integer.toString(price);
    }

}
