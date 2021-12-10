package vendingmachine.controller;

import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;

public class VendingMachineController {
    private final InputView input;

    public VendingMachineController() {
        this.input = new InputView();
    }

    public void run() {
        VendingMachine vendingMachine = createVendingMachine();
    }

    private VendingMachine createVendingMachine() {
        int changes = input.inputVendingmachineChange();
        return new VendingMachine(changes);
    }
}
