package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.model.User;
import vendingmachine.model.VendingMachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachineController vendingMachineController = new VendingMachineController(new VendingMachine(),
            new User());
        vendingMachineController.run();
    }
}
