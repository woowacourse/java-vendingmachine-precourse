package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public int requestVendingMachineHoldingAmount() {
        System.out.println(Constant.VENDING_MACHINE_HOLING_AMOUNT_REQUEST_STRING);
        return Integer.parseInt(Console.readLine());
    }
}
