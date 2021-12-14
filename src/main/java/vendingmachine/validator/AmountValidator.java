package vendingmachine.validator;

import static vendingmachine.constant.ErrorMessage.IS_NOT_INTEGER_ERROR_MESSAGE;
import static vendingmachine.constant.ErrorMessage.NOT_DIVISIBLE_TEN_ERROR_MESSAGE;

public class AmountValidator {

    public static void checkVendingMachineAmount(String amount) {
        if (!isDigit(amount)) {
            throw new IllegalArgumentException(IS_NOT_INTEGER_ERROR_MESSAGE);
        }
        if (!isDivisibleByTen(amount)) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_TEN_ERROR_MESSAGE);
        }
    }


    private static boolean isDigit(String amount) {
        for (char c : amount.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isDivisibleByTen(String amount) {
        if (Integer.parseInt(amount) % 10 == 0) {
            return true;
        }
        return false;
    }
}
