package vendingmachine.service;

import vendingmachine.Constants.CoinConstant;
import vendingmachine.repository.Coin;

public class CoinValidator {

    public void isValid(String number) {
        if (!isNumeric(number)) {
            throw new IllegalArgumentException(CoinConstant.NON_NUMERIC_ERROR_MESSAGE);
        }
        if (!isDivideByTen(number)) {
            throw new IllegalArgumentException(CoinConstant.DIVIDE_TEN_ERROR_MESSAGE);
        }
    }

    public boolean isNumeric(String number) {
        return number.matches(CoinConstant.NUMERIC_REGEX);
    }

    public boolean isDivideByTen(String number) {
        return Integer.parseInt(number) % 10 == 0;
    }
}
