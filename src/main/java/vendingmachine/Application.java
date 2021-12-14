package vendingmachine;

import vendingmachine.controller.VendingMachine;

public class Application {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.run();
    }
}
