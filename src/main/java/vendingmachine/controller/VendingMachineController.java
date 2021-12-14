package vendingmachine.controller;

import vendingmachine.domain.vendingMachine.VendingMachineCalculator;
import vendingmachine.domain.vendingMachine.VendingMachineRegister;

public class VendingMachineController {
    VendingMachineRegister vendingMachineRegister;
    VendingMachineCalculator vendingMachineCalculator;

    public VendingMachineController() {
        vendingMachineRegister = new VendingMachineRegister();
        vendingMachineCalculator = new VendingMachineCalculator();
    }

    public void run() {
        vendingMachineRegister.run();
        vendingMachineCalculator.run(vendingMachineRegister.getProducts());
    }
}
