package vendingmachine.controller;

import vendingmachine.domain.VendingMachine;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Controller {

    public void run() {
        int vendingMachineAmount = InputView.readVendingMachineAmount();
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.addCoins(vendingMachineAmount);
        OutputView.printCoinsOfVendingMachine(vendingMachine.getCoins());
    }
}
