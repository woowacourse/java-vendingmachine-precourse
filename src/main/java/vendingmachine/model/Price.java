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
        System.out.println("비용: "+purchasingCost);
        return purchasingCost;
    }

    public boolean isPurchasingCostValidation(int purchasingCost) {
        return subtractPrice(purchasingCost) >= 0;
    }

    protected void validatePrice(final int price) {
        if (!isFollowingPriceRule(price)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PRODUCT_PRICE_CONDITION.getErrorMessage());
        }
    }

    protected boolean isFollowingPriceRule(final int price) {
        return (price >= BASED_PRICE) && ((price % PRICE_UNIT) == 0);
    }

}
