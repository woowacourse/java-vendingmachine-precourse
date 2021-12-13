package vendingmachine;

import vendingmachine.view.VendingMachine;
import vendingmachine.view.classes.VendingMachineUI;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        VendingMachine vendingMachine = new VendingMachineUI();
        vendingMachine.start();
    }
}
