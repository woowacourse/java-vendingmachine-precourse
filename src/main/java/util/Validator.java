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
}
