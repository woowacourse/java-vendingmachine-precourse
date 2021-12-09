package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int requestMachineMoney() {
        System.out.println(Constant.MACHINE_MONEY_INPUT_REQUEST_STRING);
        return readMachineMoney();
    }

    private int readMachineMoney() {
        String input = Console.readLine();

        try {
            validateMachineMoneyInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMachineMoney();
        }
        return Integer.parseInt(input);
    }

    private void validateMachineMoneyInput(String input) throws IllegalArgumentException {
        validateMachineMoneyInputIsPositiveNumber(input);
        validateMachineMoneyInputIsMultipleOf10(input);
    }

    private void validateVendingMachineAmountIsNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constant.MACHINE_MONEY_INPUT_IS_NOT_NUMBER_ERROR_STRING);
        }
    }

    private void validateMachineMoneyInputIsPositiveNumber(String input) throws IllegalArgumentException {
        validateVendingMachineAmountIsNumber(input);
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(Constant.MACHINE_MONEY_INPUT_IS_NOT_POSITIVE_NUMBER_ERROR_STRING);
        }
    }

    private void validateMachineMoneyInputIsMultipleOf10(String input) throws IllegalArgumentException {
        validateVendingMachineAmountIsNumber(input);
        if (Integer.parseInt(input) % 10 != 0) {
            throw new IllegalArgumentException(Constant.MACHINE_MONEY_INPUT_IS_NOT_MULTIPLE_OF_10);
        }
    }
}
