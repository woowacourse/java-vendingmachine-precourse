package vendingmachine.process;

import vendingmachine.machine.Coin;
import vendingmachine.machine.Machine;
import vendingmachine.machine.MachineHoldingAmount;

public class ProcessController {
    Coin[] coins = Coin.values();

    private static int holdingAmount;

    public static void makeHoldingAmount(MachineHoldingAmount machineHoldingAmount) {
        while (true) {
            try {
                System.out.println(ProcessConstant.ASK_HOLDING_AMOUNT);
                holdingAmount = ProcessPrepareHoldingAmount.makeHoldingAmount();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        machineHoldingAmount.makeCoins();
    }

    public static void printMachineCoins() {
        System.out.println(ProcessConstant.PRINT_HOLDING_AMOUNT);
        for (int i = 0; i<coins.length; i++) {
            System.out.println(ProcessConstant.COINS[i] + coins[i].getNumber() + ProcessConstant.UNIT);
        }
    }
}
