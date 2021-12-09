package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int requestVendingMachineHold() {
        System.out.println(Constant.VENDING_MACHINE_HOLD_REQUEST_STRING);
        return readVendingMachineHold();
    }

    private int readVendingMachineHold() {
        String input = Console.readLine();

        try {
            validateVendingMachineInputIsPositiveNumber(input);
            validateVendingMachineInputIsMultipleOf10(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readVendingMachineHold();
        }
        return Integer.parseInt(input);
    }

    private void validateVendingMachineAmountIsNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constant.VENDING_MACHINE_INPUT_IS_NOT_NUMBER_ERROR_STRING);
        }
    }

    private void validateVendingMachineInputIsPositiveNumber(String input) throws IllegalArgumentException {
        validateVendingMachineAmountIsNumber(input);
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(Constant.VENDING_MACHINE_INPUT_IS_NOT_POSITIVE_NUMBER_ERROR_STRING);
        }
    }

    private void validateVendingMachineInputIsMultipleOf10(String input) throws IllegalArgumentException {
        validateVendingMachineAmountIsNumber(input);
        if (Integer.parseInt(input) % 10 != 0) {
            throw new IllegalArgumentException(Constant.VENDING_MACHINE_INPUT_IS_NOT_MULTIPLE_OF_10);
        }
    }
}
