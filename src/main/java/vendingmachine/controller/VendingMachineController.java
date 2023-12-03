package vendingmachine.controller;

import vendingmachine.domain.VendingMachine.VendingMachine;
import vendingmachine.service.VendingMachine.VendingMachineService;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    public static void play() {
        VendingMachine vendingMachine = InputView.getVendingMachine();
        OutputView.printVendingMachineCoins(vendingMachine);
    }

}
