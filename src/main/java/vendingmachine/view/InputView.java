package vendingmachine.view;

import vendingmachine.domain.VendingMachine;
import vendingmachine.util.InputUtil;

public class InputView {
    public static int readVendingMachineCoinInfo() {
        try {
            final String coinInput = InputUtil.readLine();
            return Parser.parseStringToInt(coinInput);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return readVendingMachineCoinInfo();
        }
    }
}
