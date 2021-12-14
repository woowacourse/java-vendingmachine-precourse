package vendingmachine;

import vendingmachine.controller.InputController;
import vendingmachine.controller.OrderController;

public class Application {
    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.run();
    }
}
