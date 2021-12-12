package vendingmachine.Validator;

import vendingmachine.Model.*;
import vendingmachine.SystemMessage.ErrorMessage;

public class TransactionValidator {
    public static boolean isValidateChoice(String input, VendingMachine vendingMachine) {
        try {
            if (vendingMachine.isDrinkInList(input)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.NO_SUCH_DRINK_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean isRemained(Drink chosenDrink) {
        try {
            if (chosenDrink.isSoldOut()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(ErrorMessage.SOLD_OUT_MESSAGE);
            return false;
        }
        return true;
    }
}
