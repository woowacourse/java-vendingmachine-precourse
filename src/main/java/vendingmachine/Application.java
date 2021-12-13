package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.domain.VendingMachine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachine vendingMachine = new VendingMachine();
        VendingMachineController v = new VendingMachineController(vendingMachine);
        v.run();


    }
}
