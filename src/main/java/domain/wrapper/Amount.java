package domain.wrapper;

import domain.constant.Constant;

import static util.message.ExceptionMessage.*;

public class Amount {
    private final int amount;

    private Amount(final String possesionAmount){
        validateNameBlank(possesionAmount);
        int amount = validateType(possesionAmount);
        this.amount = validateDivisibleBy10(validateRange(amount));
    }

    public static Amount create(final String possesionAmount){
        return new Amount(possesionAmount);
    }

    public int getAmount(){
        return amount;
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

    private int validateDivisibleBy10(final int amount){
        if(amount % Constant.COIN_TEN.getValue() != Constant.ZERO.getValue()){
            throw new IllegalArgumentException(String.format(TEN_UNIT_MESSAGE.getValue(), Constant.COIN_TEN.getValue()));
        }
        return amount;
    }

    private int validateRange(final int amount) {
        if (amount <= Constant.ZERO.getValue()) {
            throw new IllegalArgumentException(String.format(RANGE_MESSAGE.getValue(), Constant.ZERO.getValue()));
        }
        return amount;
    }
}
