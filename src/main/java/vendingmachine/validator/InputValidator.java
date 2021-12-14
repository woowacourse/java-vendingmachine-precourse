package vendingmachine.validator;

import vendingmachine.util.VendingMachineConstant;

public class InputValidator {
    public static void validateStringIsMoney(String input) {
        validateStringIsNumber(input);
        int inputNumber = Integer.parseInt(input);
        validateNumberIsMoreThanZero(inputNumber);
        validateNumberIsMultipleOfTen(inputNumber);
    }

    private static void validateStringIsNumber(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(VendingMachineConstant.ERROR_PREFIX_MESSAGE + VendingMachineConstant.INVALID_INPUT_NUMBER_MESSAGE);
        }
    }

    private static void validateNumberIsMoreThanZero(int inputNumber) {
        if (inputNumber < 1)
            throw new IllegalArgumentException(VendingMachineConstant.ERROR_PREFIX_MESSAGE + VendingMachineConstant.INVALID_INPUT_POSITIVE_NUMBER_MESSAGE);
    }

    private static void validateNumberIsMultipleOfTen(int inputNumber) {
        if (inputNumber % 10 != 0) {
            throw new IllegalArgumentException(VendingMachineConstant.ERROR_PREFIX_MESSAGE + VendingMachineConstant.INVALID_INPUT_MULTIPLE_OF_TEN_MESSAGE);
        }
    }
}
