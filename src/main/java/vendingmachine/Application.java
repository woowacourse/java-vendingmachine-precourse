package vendingmachine;

import vendingmachine.controller.OrderController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OrderController.init();
        OrderController.doShopping();
    }
}
