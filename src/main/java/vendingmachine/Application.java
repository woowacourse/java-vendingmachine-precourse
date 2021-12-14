package vendingmachine;

import vendingmachine.controller.InputController;
import vendingmachine.controller.OrderController;

public class Application {
    private static InputController inputController = new InputController();
    private static OrderController orderController = new OrderController();

    public static void main(String[] args) {
        inputController.init();
        orderController.start();
    }
}
