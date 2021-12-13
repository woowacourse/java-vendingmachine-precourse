package vendingmachine.view;

import static vendingmachine.constants.InputMessages.*;
import static vendingmachine.constants.SystemConstants.SEMICOLON;
import static vendingmachine.validator.NumberInputValidator.*;
import static vendingmachine.validator.MenuInputFormatValidator.*;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.domain.Menu;
import vendingmachine.domain.Merchandise;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static String requestVendingMachineMoneyInput() {
        System.out.println(REQUEST_VENDING_MACHINE_INITIAL_MONEY);
        return Console.readLine();
    }

    public static Menu getMenuInput() {
        try {
            System.out.println(REQUEST_MENU_INPUT);
            String menuInput = Console.readLine();
            validateMenuInputFormat(menuInput);

            return generateMenuFromInput(menuInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMenuInput();
        }
    }

    private static Menu generateMenuFromInput(String menuInput) {
        String[] merchandiseInfos = menuInput.split(SEMICOLON);

        List<Merchandise> merchandiseList = new ArrayList<>();
        for (String merchandiseInfo : merchandiseInfos) {
            merchandiseList.add(new Merchandise(merchandiseInfo));
        }
        return new Menu(merchandiseList);
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
