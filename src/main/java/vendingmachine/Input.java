package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int requestVendingMachineHoldingAmount() {
        System.out.println(Constant.VENDING_MACHINE_HOLING_AMOUNT_REQUEST_STRING);
        return readVendingMachineHoldingAmount();
    }

    private int readVendingMachineHoldingAmount() {
        String input = Console.readLine();
        try {
            validateVendingMachineAmountIsNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println(Constant.VENDING_MACHINE_REQUEST_IS_NOT_NUMBER_ERROR_STRING);
            return readVendingMachineHoldingAmount();
        }
        return Integer.parseInt(input);
    }

    private void validateVendingMachineAmountIsNumber(String input) throws IllegalArgumentException {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
