package vendingmachine.validator;

import static vendingmachine.constant.ErrorMessage.*;
import static vendingmachine.constant.SystemMessage.ONE_HUNDRED_WON;
import static vendingmachine.constant.SystemMessage.TEN_WON;

public class AmountValidator {

    public static void checkVendingMachineAmount(String amount) {
        if (isNotDigit(amount)) {
            throw new IllegalArgumentException(IS_NOT_INTEGER_ERROR_MESSAGE);
        }
        if (isNotDivisibleByTen(amount)) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_TEN_ERROR_MESSAGE);
        }
    }

    public static void checkProductPrice(String price) {
        int priceInt = Integer.parseInt(price);
        if (priceInt < ONE_HUNDRED_WON) {
            throw new IllegalArgumentException(IS_NOT_POSSIBLE_PRODUCT_PRICE_ERROR_MESSAGE);
        }
        if (isNotDivisibleByTen(price)) {
            throw new IllegalArgumentException(NOT_DIVISIBLE_TEN_ERROR_MESSAGE);
        }
    }

    protected static boolean isNotDigit(String amount) {
        for (char c : amount.toCharArray()) {
            if (!Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }

    protected static boolean isNotDivisibleByTen(String amount) {
        return Integer.parseInt(amount) % TEN_WON != 0;
    }
}
