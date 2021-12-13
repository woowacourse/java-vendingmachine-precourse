package vendingmachine.process;

import vendingmachine.machine.Machine;
import vendingmachine.machine.MachineHoldingAmount;

public class ProcessController {
    private int holdingAmount;
    MachineHoldingAmount machineHoldingAmount;

    public ProcessController(MachineHoldingAmount machineHoldingAmount) {
        this.machineHoldingAmount = machineHoldingAmount;
    }

    public void makeHoldingAmount() {
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

}
