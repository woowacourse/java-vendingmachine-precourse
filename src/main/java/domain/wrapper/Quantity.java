package domain.wrapper;

import domain.constant.Constant;

import java.util.Objects;

import static util.message.ExceptionMessage.*;
import static util.message.ExceptionMessage.TEN_UNIT_MESSAGE;

public class Quantity {
    private final int quantity;

    private Quantity(final String quantityInfo){
        validateBlank(quantityInfo);
        int amount = validateType(quantityInfo);
        amount = validateRange(amount);
        this.quantity = amount;
    }

    public static Quantity create(final String quantityInfo){
        return new Quantity(quantityInfo);
    }

    private void validateBlank(final String productDetail){
        if (productDetail == null || productDetail.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(BLANK_MESSAGE.getValue(), "수량"));
        }
    }

    private int validateType(final String priceInfo) {
        int amount;
        try {
            amount = Integer.parseInt(priceInfo);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(TYPE_MESSAGE.getValue(), "수량"));
        }
        return amount;
    }

    private int validateRange(final int amount) {
        if (amount <= Constant.ZERO.getValue()) {
            throw new IllegalArgumentException(String.format(RANGE_MESSAGE.getValue(), Constant.ZERO.getValue()));
        }
        return amount;
    }

    @Override
    public boolean equals(Object diffQuantity) {
        if (this == diffQuantity) return true;
        if (diffQuantity == null || getClass() != diffQuantity.getClass()) return false;
        Quantity quantityInfo = (Quantity) diffQuantity;
        return Objects.equals(quantity, quantityInfo.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity);
    }

    public int getQuantity() {
        return quantity;
    }
}
