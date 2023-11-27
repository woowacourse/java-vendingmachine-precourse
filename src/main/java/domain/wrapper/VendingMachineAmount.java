package domain.wrapper;

import domain.constant.Constant;

import static util.message.ExceptionMessage.*;

public class VendingMachineAmount {
    private final int vendingMachineAmount;

    private VendingMachineAmount(final String possesionAmount){
        validateNameBlank(possesionAmount);
        int amount = validateType(possesionAmount);
        validateRange(amount);
        validateDivisibleBy10(amount);
        this.vendingMachineAmount = amount;
    }

    public static VendingMachineAmount create(final String possesionAmount){
        return new VendingMachineAmount(possesionAmount);
    }

    public int getVendingMachineAmount(){
        return vendingMachineAmount;
    }

    private void validateNameBlank(final String possesionAmount) {
        if (possesionAmount == null || possesionAmount.trim().isEmpty()) {
            throw new IllegalArgumentException(String.format(BLANK_MESSAGE.getValue(), "보유금액"));
        }
    }

    private int validateType(final String amount) {
        int count;
        try {
            count = Integer.parseInt(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format(TYPE_MESSAGE.getValue(), "보유금액"));
        }
        return count;
    }

    private void validateDivisibleBy10(final int amount){
        if(amount % Constant.COIN_TEN.getValue() != Constant.ZERO.getValue()){
            throw new IllegalArgumentException(String.format(UNIT_MESSAGE.getValue(), Constant.COIN_TEN.getValue()));
        }
    }

    private void validateRange(final int amount) {
        if (amount < Constant.ZERO.getValue()) {
            throw new IllegalArgumentException(String.format(RANGE_MESSAGE.getValue(), Constant.ZERO.getValue()));
        }
    }
}
