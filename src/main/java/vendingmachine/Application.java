package vendingmachine;

import vendingmachine.Controller.MainController;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.start();
    }
}
