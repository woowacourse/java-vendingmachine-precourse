package vendingmachine.domain;

import vendingmachine.utils.ExceptionMessages;

public class Product {

    public static final int BASED_PRICE = 100;

    private final String name;
    private final int price;
    private final int count;

    public Product(final String name, final int price, final int count) {
        validateProduct(price);
        this.name = name;
        this.price = price;
        this.count = count;
    }

    protected void validateProduct(final int price) {
        validatePrice(price);
    }

    protected void validatePrice(final int price) {
        if (!isFollowingPriceRule(price)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PRODUCT_PRICE_FORMAT.getErrorMessage());
        }
    }

    protected boolean isFollowingPriceRule(final int price) {
        return (price > BASED_PRICE) && ((price % 10) == 0);
    }
}
