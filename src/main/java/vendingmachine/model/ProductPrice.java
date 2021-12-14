package vendingmachine.model;

import vendingmachine.utils.StringUtils;

public class ProductPrice {
    private static final int DIVISOR = 10;
    private static final int ZERO = 0;
    private static final int LEAST_PRICE = 100;
    private static final String PRICE_NOT_NUMERIC_MESSAGE = "상품 가격은 정수만 입력 가능합니다.";
    private static final String PRICE_LESS_THAN_LEAST_PRICE_MESSAGE = "상품 가격은 최소 100원 이상이어야 합니다.";
    private static final String PRICE_NOT_DIVIDABLE_BY_DIVISOR_MESSAGE = "상품 가격은 최소 10원 단위로 입력해야 합니다.";

    private int price;

    public ProductPrice(String priceString) {
        validatePricePolicy(priceString);
        this.price = Integer.parseInt(priceString);
    }

    public int get() {
        return price;
    }

    public boolean canBuy(int inputAmount) {
        return inputAmount >= price;
    }

    private void validatePricePolicy(String priceString) {
        validatePriceNumeric(priceString);

        int price = Integer.parseInt(priceString);

        validatePriceRange(price);
        validatePriceUnit(price);
    }

    private void validatePriceNumeric(String priceString) {
        if (!StringUtils.isNumeric(priceString)) {
            throw new IllegalArgumentException(PRICE_NOT_NUMERIC_MESSAGE);
        }
    }

    private void validatePriceRange(int price) {
        if (!isMoreThanLeastPrice(price)) {
            throw new IllegalArgumentException(PRICE_LESS_THAN_LEAST_PRICE_MESSAGE);
        }
    }

    private void validatePriceUnit(int price) {
        if (!isDividableByDivisor(price)) {
            throw new IllegalArgumentException(PRICE_NOT_DIVIDABLE_BY_DIVISOR_MESSAGE);
        }
    }

    private boolean isMoreThanLeastPrice(int price) {
        return price >= LEAST_PRICE;
    }

    private boolean isDividableByDivisor(int price) {
        return price % DIVISOR == ZERO;
    }

}
