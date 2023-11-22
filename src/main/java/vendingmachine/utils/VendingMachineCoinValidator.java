package vendingmachine.utils;

import static vendingmachine.exception.ErrorMessage.INVALID_VENDING_MACHINE_COINS;

public class VendingMachineCoinValidator {
    public static long safeParseLong(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_VENDING_MACHINE_COINS.getMessage());
        }
    }


}
