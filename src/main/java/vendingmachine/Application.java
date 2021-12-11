package vendingmachine;

import vendingmachine.controller.InputController;

public class Application {
    public static void main(String[] args) {
        InputController inputController = new InputController();
        inputController.scanHoldingMoney();
    }
}
