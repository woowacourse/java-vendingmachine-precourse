package vendingmachine;

import java.util.Arrays;

public class Validator {
    public static void validateMachineMoneyInput(String input) throws IllegalArgumentException {
        validateMachineMoneyInputIsPositiveNumber(input);
        validateMachineMoneyInputIsMultipleOf10(input);
    }

    private static void validateVendingMachineAmountIsNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constant.MACHINE_MONEY_INPUT_IS_NOT_NUMBER_ERROR_STRING);
        }
    }

    private static void validateMachineMoneyInputIsPositiveNumber(String input) throws IllegalArgumentException {
        validateVendingMachineAmountIsNumber(input);
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(Constant.MACHINE_MONEY_INPUT_IS_NOT_POSITIVE_NUMBER_ERROR_STRING);
        }
    }

    private static void validateMachineMoneyInputIsMultipleOf10(String input) throws IllegalArgumentException {
        validateVendingMachineAmountIsNumber(input);
        if (Integer.parseInt(input) % 10 != 0) {
            throw new IllegalArgumentException(Constant.MACHINE_MONEY_INPUT_IS_NOT_MULTIPLE_OF_10);
        }
    }

    public static void validateMachineProductInput(String input) throws IllegalArgumentException {
        String[] products = input.split(";");

        for (String product : products) {
            validateMachineProductInputBracket(product);
            validateMachineProductInputDividedByComma(product);
        }
    }

    private static void validateMachineProductInputBracket(String product) throws IllegalArgumentException {
        if (!product.startsWith("[") || !product.endsWith("]")) {
            throw new IllegalArgumentException(Constant.MACHINE_PRODUCT_INPUT_IS_NOT_RIGHT_FORM_ERROR_STRING);
        }
    }

    private static void validateMachineProductInputDividedByComma(String product) throws IllegalArgumentException {
        product = product.replaceAll("[]\\[]", "");
        String[] str = Arrays.stream(product.split(","))
                .filter(s -> !s.isEmpty())
                .toArray(String[]::new);
        if (str.length != 3) {
            throw new IllegalArgumentException(Constant.MACHINE_PRODUCT_INPUT_IS_NOT_RIGHT_FORM_ERROR_STRING);
        }
    }
}
