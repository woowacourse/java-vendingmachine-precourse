package vendingmachine.Validator;

import vendingmachine.Constant.Constant;
import vendingmachine.SystemMessage.SystemMessage;

public class DrinkListValidator {
    public static boolean isValidateDrinkList(String input) {
        int flag = Constant.TRUE;
        String[] drinks = input.split(Constant.SEMICOLON);
        for (String drink : drinks) {
            flag *= isValidateDrinkInfo(drink.trim());
        }
        return (flag == Constant.TRUE);
    }

    private static int isValidateDrinkInfo(String input) {
        input = input.substring(1, input.length() - 1);
        String[] drinkInfo = input.split(Constant.COMMA);
        if (!isValidateInfoFormat(drinkInfo)) {
            return Constant.FALSE;
        }
        if (!isValidatePrice(drinkInfo[Constant.PRICE_INDEX].trim()) || !isValidateAmount(drinkInfo[Constant.STOCK_INDEX].trim())) {
            return Constant.FALSE;
        }
        return Constant.TRUE;
    }

    private static boolean isValidateInfoFormat(String[] input) {
        try {
            if (input.length != 3) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(SystemMessage.WRONG_FORMAT_MESSAGE);
            return false;
        }
        return true;
    }

    private static boolean isValidatePrice(String input) {
        if (!NumberValidator.isErrorInNumberFormat(input)) {
            return false;
        }
        int inputNumber = Integer.parseInt(input);
        if (!NumberValidator.isBiggerThan100(inputNumber) || !NumberValidator.isMultipleOfTen(inputNumber)) {
            return false;
        }
        return true;
    }

    private static boolean isValidateAmount(String input) {
        if (!NumberValidator.isErrorInNumberFormat(input)) {
            return false;
        }
        int inputNumber = Integer.parseInt(input);
        if (!NumberValidator.isPositiveNumber(inputNumber)) {
            return false;
        }
        return true;
    }
}
