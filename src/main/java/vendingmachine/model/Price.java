package vendingmachine.domain;

import vendingmachine.utils.ExceptionMessages;

public class Price {

    public static final int BASED_PRICE = 100;
    public static final int PRICE_UNIT = 10;

    private final int price;

    public Price(final int price) {
        this.price = price;
    }

    public int subtract(int money, int price) {
        return money - price;
    }

    public void validateMoney(int money, int price) {
        if(subtract(money, price) < 0){
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_INPUT_MONEY_LESS_THAN_ZERO.getErrorMessage());
        }
    }

    protected void validatePrice(final int price) {
        if (!isFollowingPriceRule(price)) {
            throw new IllegalArgumentException(ExceptionMessages.ERROR_MESSAGE_PRODUCT_PRICE_FORMAT.getErrorMessage());
        }
    }

    protected boolean isFollowingPriceRule(final int price) {
        return (price >= BASED_PRICE) && ((price % PRICE_UNIT) == 0);
    }

}
