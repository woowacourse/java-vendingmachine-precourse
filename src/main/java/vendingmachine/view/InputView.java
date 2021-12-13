package vendingmachine.view;

import static vendingmachine.constants.InputMessages.*;
import static vendingmachine.validator.NumberInputValidator.*;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String requestVendingMachineMoneyInput() {
        System.out.println(REQUEST_VENDING_MACHINE_INITIAL_MONEY);
        return Console.readLine();
    }

    public static String requestMenuInput() {
        System.out.println(REQUEST_MENU_INPUT);
        return Console.readLine();
    }

    public static int getCustomerMoneyInput() {
        try {
            System.out.println(REQUEST_CUSTOMER_MONEY_INPUT);

            String input = Console.readLine();
            validateMoneyInput(input);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getCustomerMoneyInput();
        }
    }

    public static String getPurchaseInfoInput() {
        System.out.println(REQUEST_PURCHASE_INPUT);
        return Console.readLine();
    }
}
