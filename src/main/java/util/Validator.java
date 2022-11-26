package util;

import constant.ErrorLog;
import vendingmachine.Coin;

public class Validator {
    public static void validatePositiveInteger(String string) {
        if (!string.matches("^[0-9]{1,9}$")) {
            throw new IllegalArgumentException(ErrorLog.NOT_NUMBER_INPUT.getLog());
        }
    }

    public static void validateDivisibleByMinimumMonetaryUnit(int money) {
        if (money % Coin.COIN_10.getAmount() != 0) {
            throw new IllegalArgumentException(ErrorLog.NOT_DIVISIBLE.getLog());
        }
    }

    public static void validateProductForm(String string) {
        if (!string.matches("^\\[\\S+,\\d{1,9}+,\\d{1,9}]$")) {
            throw new IllegalArgumentException(ErrorLog.INVALID_FORM.getLog());
        }
    }

    public static void validateEnoughMoney(int money) {
        if (money < 100) {
            throw new IllegalArgumentException(ErrorLog.NOT_ENOUGH_MONEY.getLog());
        }
    }

    public static void validateNotZero(int number) {
        if (number == 0) {
            throw new IllegalArgumentException(ErrorLog.ZERO_NUMBER.getLog());
        }
    }
}
