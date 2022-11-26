package util;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

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
        if (!string.matches("^\\[[a-zA-Z0-9가-힣]+,\\d{1,9}+,\\d{1,9}]$")) {
            throw new IllegalArgumentException(ErrorLog.NOT_NUMBER_INPUT.getLog());
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

    public static void validateNotSpace(String string) {
        if (string.matches("\\S")) {
            throw new IllegalArgumentException(ErrorLog.ONLY_SPACE.getLog());
        }
    }
}
