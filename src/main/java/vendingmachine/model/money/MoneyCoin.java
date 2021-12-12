package vendingmachine.model.money;

import static vendingmachine.util.validator.Validator.*;

import java.util.Arrays;
import java.util.Objects;

import vendingmachine.model.enums.Coin;

public class MoneyCoin {
    public static final String NOT_CORRECT_COIN_TYPE = "[ERROR] 10원, 50원, 100원, 500원 중 입력하세요";
    private int amount;

    public MoneyCoin(int amount) {
        validateCoin(amount);
        this.amount = amount;
    }

    private void validateCoin(int amount) {
        try {
            validateNonNegative(amount);
            if (!isValidCoin(amount)) {
                throw new IllegalArgumentException(NOT_CORRECT_COIN_TYPE);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isValidCoin(int amount) {
        return Arrays.stream(Coin.values()).anyMatch(coin -> coin.getValue() == amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        MoneyCoin moneyCoin = (MoneyCoin)o;
        return amount == moneyCoin.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount);
    }

    @Override
    public String toString() {
        return  amount + "원";
    }
}
