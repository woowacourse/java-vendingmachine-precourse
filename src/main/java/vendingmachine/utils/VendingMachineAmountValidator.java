package vendingmachine.utils;

import static vendingmachine.exception.ErrorMessage.INVALID_VENDING_MACHINE_AMOUNT;
import static vendingmachine.exception.ErrorMessage.NOT_NUMERIC_VENDING_MACHINE_AMOUNT;

public class VendingMachineAmountValidator {
    private static final int MINIMUM_AMOUNT = 10;
    public static long safeParseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_VENDING_MACHINE_AMOUNT.getMessage());
        }
    }

    public static void validateDividedByMinimumAmount(long amount) {
        if (amount % MINIMUM_AMOUNT != 0) {
            throw new IllegalArgumentException(INVALID_VENDING_MACHINE_AMOUNT.getMessage());
        }
    }

}
