package vendingmachine;

import vendingmachine.controller.RequestController;
import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.VendingMachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachine vendingMachine = RequestController.requestVendingMachine();
        VendingMachineController vendingMachineController = new VendingMachineController(vendingMachine);
        vendingMachineController.insertMoney();
        vendingMachineController.run();
    }
}
