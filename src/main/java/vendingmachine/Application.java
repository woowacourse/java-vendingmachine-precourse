package vendingmachine;

import controller.VendingMachineController;

public class Application {
    public static void main(String[] args) {
        VendingMachineController vendingMachineController = new VendingMachineController();
        vendingMachineController.start();
    }
}
