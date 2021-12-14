package vendingmachine.model;

import vendingmachine.utils.ExceptionMessages;

public class Price {

    public static final int BASED_PRICE = 100;
    public static final int PRICE_UNIT = 10;

    private final int price;

    public Price(final int price) {
        isFollowingPriceRule(price);
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public int subtractPrice(int purchasingCost) {
        purchasingCost = purchasingCost - this.price;

        return purchasingCost;
    }

    protected void isFollowingPriceRule(final int price) {
        if (!(price >= BASED_PRICE) && ((price % PRICE_UNIT) == 0)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PRODUCT_PRICE_CONDITION.getErrorMessage());
        }
    }

    public boolean isCheaper(final int cheapestProductPrice) {
        return this.price < cheapestProductPrice;
    }

    public boolean isShortMoney(final int purchasingCost) {
        return (purchasingCost - this.price) >= 0;
    }

}
