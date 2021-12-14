package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.VendingMachineConstant;
import vendingmachine.validator.InputValidator;

public class InputView {

    public static String inputVendingMachineMoney() {
        System.out.println(VendingMachineConstant.INPUT_VENDING_MACHINE_MONEY_MESSAGE);
        return inputMoney();
    }

    public static String inputProductInfo() {
        System.out.println(VendingMachineConstant.INPUT_PRODUCT_INFO_MESSAGE);
        String inputProductInfo = Console.readLine();
        // TODO 검증 로직
        return inputProductInfo;
    }

    public static String inputUserMoney() {
        System.out.println(VendingMachineConstant.INPUT_USER_MONEY_MESSAGE);
        return inputMoney();
    }

    private static String inputMoney() {
        while (true) {
            String inputMoney = Console.readLine();
            try {
                InputValidator.validateStringIsMoney(inputMoney);
                return inputMoney;
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
    }
}
