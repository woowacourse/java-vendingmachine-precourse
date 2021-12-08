package vendingmachine.controller;

import vendingmachine.View.InputView;
import vendingmachine.domain.VendingMachine;

public class VendingMachineController {
    public void run() {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.setMachineMoney(InputView.printSetMachineMoney());
    }
}
