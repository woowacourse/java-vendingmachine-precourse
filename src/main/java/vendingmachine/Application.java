package vendingmachine;

import vendingmachine.domain.VendingMachine;

public class Application {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();
        machine.run();
    }
}
