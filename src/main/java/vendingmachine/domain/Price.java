package vendingmachine.domain;

import static vendingmachine.Constant.*;
import static vendingmachine.ErrorMessage.*;

public class Price extends Number {
    private int price;

    public Price(String priceInput) {
        this.price = validate(priceInput);
    }

    public Price(int price) {
        validateItIsPositive(price);
        validateUnitIsCorrect(price);
        this.price = price;
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

    @Override
    public int intValue() {
        return price;
    }

    @Override
    public long longValue() {
        return (long)price;
    }

    @Override
    public float floatValue() {
        return (float)price;
    }

    @Override
    public double doubleValue() {
        return (double)price;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Price) {
            return price == ((Price)obj).intValue();
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(price);
    }
}
