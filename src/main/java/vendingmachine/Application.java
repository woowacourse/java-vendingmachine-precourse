package vendingmachine;

import vendingmachine.Domain.Machine;

public class Application {
    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.buyProducts();
    }
}
