package vendingmachine;

import vendingmachine.servicesource.VendingMachine;

public class Application {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.runStart();
    }
}
