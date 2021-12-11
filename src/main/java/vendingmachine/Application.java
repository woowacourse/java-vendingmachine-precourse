package vendingmachine;

import vendingmachine.controller.VendingMachineController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachineController vendingMachineController = new VendingMachineController();
        vendingMachineController.run();
    }
}
