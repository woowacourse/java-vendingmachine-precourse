package vendingmachine.process;

import vendingmachine.machine.Machine;
import vendingmachine.machine.MachineHoldingAmount;

public class ProcessController {
    private static int holdingAmount;

    public static void makeHoldingAmount() {
        while (true) {
            try {
                System.out.println(ProcessConstant.ASK_HOLDING_AMOUNT);
                holdingAmount = ProcessPrepareHoldingAmount.makeHoldingAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void makeMachineCoins(MachineHoldingAmount machineHoldingAmount) {
        machineHoldingAmount.makeCoins();
    }
}
