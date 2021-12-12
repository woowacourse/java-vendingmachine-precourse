package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.VendingMachine;

public class Application {
    public static void main(String[] args) {
        VendingMachineController vendingMachineController = new VendingMachineController(new VendingMachine());
        vendingMachineController.execute();
    }
}
