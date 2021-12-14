package vendingmachine.utils;

import vendingmachine.domain.Merchandise;

import static vendingmachine.constants.ExceptionMessages.*;
import static vendingmachine.constants.SystemConstants.NO_MERCHANDISE_LEFT;

public class PurchaseValidator {

    public static void validateAvailableMerchandise(Merchandise merchandise, int moneyLeft) {
        if (merchandise.getPrice() > moneyLeft) throw new IllegalArgumentException(NOT_ENOUGH_MONEY_EXCEPTION);
        if (merchandise.getNumber() == NO_MERCHANDISE_LEFT) throw new IllegalArgumentException(SOLD_OUT_EXCEPTION);
    }
}
