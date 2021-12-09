package vendingmachine;

import vendingmachine.controller.MainController;
import vendingmachine.domain.Coin;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.playGame();
    }
}
