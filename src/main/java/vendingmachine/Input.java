package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int requestVendingMachineHoldingAmount() {
        System.out.println(Constant.VENDING_MACHINE_HOLING_AMOUNT_REQUEST_STRING);
        String input = Console.readLine();
        validateVendingMachineAmountIsNumber(input);
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
