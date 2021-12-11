package vendingmachine.Validator;

import vendingmachine.Model.*;
import vendingmachine.SystemMessage.SystemMessage;

public class TransactionValidator {
    public static boolean isValidateChoice(String input, VendingMachine vendingMachine) {
        try {
            if (vendingMachine.isDrinkInList(input)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(SystemMessage.NO_SUCH_DRINK_MESSAGE);
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
            System.out.println(SystemMessage.SOLD_OUT_MESSAGE);
            return false;
        }
        return true;
    }
}
