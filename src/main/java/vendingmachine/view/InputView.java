package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.VendingMachineConstant;

public class InputView {
    public static String inputVendingMachineMoney() {
        System.out.println(VendingMachineConstant.INPUT_VENDING_MACHINE_MONEY);
        return Console.readLine();
    }
}
