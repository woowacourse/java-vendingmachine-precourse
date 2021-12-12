package vendingmachine;

import vendingmachine.domain.VendingMachine;

public class Application {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.print();
    }
}
