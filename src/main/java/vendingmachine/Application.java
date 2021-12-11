package vendingmachine;

import vendingmachine.controller.MachineController;
import vendingmachine.model.VendingMachine;

public class Application {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        MachineController machineController = new MachineController(vendingMachine);
        machineController.run();
    }
}
