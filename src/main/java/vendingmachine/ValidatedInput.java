package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class ValidatedInput {
    public int requestMachineMoney() {
        System.out.println(Constant.MACHINE_MONEY_INPUT_REQUEST_STRING);
        return readMachineMoney();
    }

    private int readMachineMoney() {
        String input = Console.readLine();

        try {
            Validator.validateMachineMoneyInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMachineMoney();
        }
        return Integer.parseInt(input);
    }

    public String requestMachineProduct() {
        System.out.println(Constant.MACHINE_PRODUCT_INPUT_REQUEST_STRING);
        return readMachineProduct();
    }

    private String readMachineProduct() {
        String input = Console.readLine();

        try {
            Validator.validateMachineProductInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMachineProduct();
        }
        return input;
    }
}
