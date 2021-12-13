package vendingmachine.model;

import vendingmachine.utils.ExceptionMessages;

public class Price {

    public static final int BASED_PRICE = 100;
    public static final int PRICE_UNIT = 10;

    private final int price;

    public Price(final int price) {
        validatePrice(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int subtractPrice(int purchasingCost) {
        purchasingCost = purchasingCost - this.price;
        return purchasingCost;
    }

    protected void validatePrice(final int price) {
        if (!isFollowingPriceRule(price)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PRODUCT_PRICE_CONDITION.getErrorMessage());
        }
    }

    protected boolean isFollowingPriceRule(final int price) {
        return (price >= BASED_PRICE) && ((price % PRICE_UNIT) == 0);
    }

    public boolean isCheaper(final int cheapestProductPrice) {
        return this.price < cheapestProductPrice;
    }

}
