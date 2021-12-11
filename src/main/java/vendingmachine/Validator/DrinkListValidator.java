package vendingmachine.Validator;

import vendingmachine.SystemMessage.SystemMessage;

public class DrinkListValidator {
    public static boolean isValidateDrinkList(String input) {
        int flag = 1;
        String[] drinks = input.split(";");
        for (String drink : drinks) {
            flag *= isValidateDrinkInfo(drink);
        }
        return (flag == 1);
    }

    private static int isValidateDrinkInfo(String input) {
        input = input.substring(1, input.length() - 1);
        String[] drinkInfo = input.split(",");
        if (!isValidateInfoFormat(drinkInfo)) {
            return 0;
        }
        if (!isValidatePrice(drinkInfo[1]) || !isValidateAmount(drinkInfo[2])) {
            return 0;
        }
        return 1;
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
