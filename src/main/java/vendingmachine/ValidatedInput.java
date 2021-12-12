package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import static vendingmachine.Constant.*;

public class ValidatedInput {
    public int requestMachineMoney() {
        System.out.println(MACHINE_MONEY_INPUT_REQUEST_STRING);
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
        System.out.println();
        return Integer.parseInt(input);
    }

    public String requestMachineProduct() {
        System.out.println(MACHINE_PRODUCT_INPUT_REQUEST_STRING);
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
        System.out.println();
        return input;
    }

    public int requestUserMoney() {
        System.out.println(USER_MONEY_INPUT_REQUEST_STRING);
        return readUserMoney();
    }

    private int readUserMoney() {
        String input = Console.readLine();

        try {
            Validator.validateUserMoneyInput(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readUserMoney();
        }
        System.out.println();
        return Integer.parseInt(input);
    }

    public String requestBuyingProduct() {
        System.out.println(BUYING_PRODUCT_INPUT_REQUEST_STRING);
        String input = Console.readLine();

        System.out.println();
        return input;
    }
}
