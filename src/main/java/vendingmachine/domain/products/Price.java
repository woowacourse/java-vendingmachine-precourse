package vendingmachine.domain.products;

import vendingmachine.exception.PriceDividingException;
import vendingmachine.exception.PriceRangeException;

public class Price {

    private static final int MIN_PRICE = 100;
    private static final int MAX_PRICE = 1_000_000_000;
    private static final int DIVIDING_PRICE = 10;
    private static final int DIVIDING_RESULT = 0;

    private final int price;

    private Price(int price) {
        validate(price);
        this.price = price;
    }

    public static Price from(int price) {
        return new Price(price);
    }

    private static void validate(int price) {
        validateRange(price);
        validateDividing(price);
    }

    private static void validateRange(int price) {
        if (price < MIN_PRICE || price > MAX_PRICE) {
            throw new PriceRangeException(MIN_PRICE, MAX_PRICE);
        }
    }

    private static void validateDividing(int price) {
        if ((price % DIVIDING_PRICE) != DIVIDING_RESULT){
            throw new PriceDividingException(DIVIDING_PRICE);
        }
    }
}
