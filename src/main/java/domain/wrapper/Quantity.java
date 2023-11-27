package domain.wrapper;

import domain.constant.Constant;
import util.exception.NotEnoughBalanceException;
import util.exception.SoldOutException;
import util.message.ExceptionMessage;

import java.util.Objects;

import static util.message.ExceptionMessage.*;

public class Quantity {

    private static final int SUBTRACT_QUANTITY = 1;
    private int quantity;

    private Quantity(final String quantityInfo){
        validateBlank(quantityInfo);
        int amount = validateType(quantityInfo);
        amount = validateRange(amount);
        this.quantity = amount;
    }

    private Quantity(int quantity) {
        this.quantity = quantity;
    }

    public static Quantity create(final String quantityInfo){
        return new Quantity(quantityInfo);
    }

    public void add(int amount) {
        this.quantity += amount;
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

    public Quantity subtract() {
        validateAbleToSubtractItemQuantity(quantity);
        return new Quantity(quantity - SUBTRACT_QUANTITY);
    }

    private void validateAbleToSubtractItemQuantity(int quantity){
        if (quantity <= 0) {
            throw new SoldOutException();
        }
    }
}
