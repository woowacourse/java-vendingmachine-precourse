package vendingmachine.Validator;

import vendingmachine.Constant.Constant;
import vendingmachine.SystemMessage.SystemMessage;

public class NumberValidator {
    public static boolean isErrorInNumberFormat(String input) {
        try {
            if (!isNumberFormat(input)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(SystemMessage.NOT_NUMBER_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean isNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static boolean isMultipleOfTen(int inputNumber) {
        try {
            if ((inputNumber % Constant.TEN) != Constant.ZERO) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(SystemMessage.NOT_MULTIPLE_OF_10_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean isPositiveNumber(int inputNumber) {
        try {
            if (inputNumber < Constant.ZERO) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(SystemMessage.NOT_POSITIVE_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean isBiggerThan100(int inputNumber) {
        try {
            if (inputNumber < Constant.HUNDRED) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(SystemMessage.LESS_THAN_100_MESSAGE);
            return false;
        }
        return true;
    }
}
