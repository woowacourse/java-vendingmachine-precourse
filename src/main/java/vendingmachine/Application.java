package vendingmachine;

import vendingmachine.controller.VendingMachineController;

public class Application {
    public static void main(String[] args) {
        new VendingMachineController()
                .setup()
                .start();
    }
}
