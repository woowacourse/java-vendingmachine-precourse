package vendingmachine.validators;

import vendingmachine.domain.Coin;

public class ProductPriceValidator {
    private static final int MINIMAL_PRODUCT_MONEY = 100;
    private static final String BOUNDARY_EXCEPTION = String.format("상품의 최소 금액은 %d원입니다", MINIMAL_PRODUCT_MONEY);
    private static final String DIVIDED_BYCOIN_EXCEPTION = String.format("상품 금액은 10원 단위로 나누어 떨어집니다.",
            Coin.COIN_10.getAmount());


    public static void validate(final int price) {
        isBoundary(price);
        isDivided(price);
    }

    private static void isDivided(final int price) {
        if (Coin.COIN_10.isDivided(price)) {
            return;
        }
        throw new IllegalArgumentException(DIVIDED_BYCOIN_EXCEPTION);
    }

    private static void isBoundary(final int price) {
        if (price < MINIMAL_PRODUCT_MONEY) {
            throw new IllegalArgumentException(BOUNDARY_EXCEPTION);
        }
    }
}
