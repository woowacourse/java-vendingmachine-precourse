package domain.wrapper;

import domain.constant.Constant;

import java.util.Objects;

import static util.message.ExceptionMessage.*;

public class Price {
    private final int price;

    private Price(final String priceInfo){
        validateBlank(priceInfo);
        int amount = validateType(priceInfo);
        amount = validateRange(amount);
        amount = validateDivisibleBy10(amount);
        this.price = amount;
    }

    public static Price create(final String priceInfo){
        return new Price(priceInfo);
    }

    private void validateBlank(final String productDetail){
        if (productDetail == null || productDetail.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(BLANK_MESSAGE.getValue(), "가격"));
        }
    }

    private int validateType(final String priceInfo) {
        int amount;
        try {
            amount = Integer.parseInt(priceInfo);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(TYPE_MESSAGE.getValue(), "가격"));
        }
        return amount;
    }

    private int validateRange(final int amount) {
        if (amount < Constant.COIN_HUNDRED.getValue()) {
            throw new IllegalArgumentException(String.format(RANGE_MESSAGE.getValue(), Constant.COIN_HUNDRED.getValue()));
        }
        return amount;
    }

    private int validateDivisibleBy10(final int amount){
        if(amount % Constant.COIN_TEN.getValue() != Constant.ZERO.getValue()){
            throw new IllegalArgumentException(String.format(TEN_UNIT_MESSAGE.getValue(), Constant.COIN_TEN.getValue()));
        }
        return amount;
    }

    @Override
    public boolean equals(Object diffPrice) {
        if (this == diffPrice) return true;
        if (diffPrice == null || getClass() != diffPrice.getClass()) return false;
        Price priceInfo = (Price) diffPrice;
        return Objects.equals(price, priceInfo.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }

    public int getPrice() {
        return price;
    }
}
