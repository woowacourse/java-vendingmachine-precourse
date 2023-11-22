package vendingmachine;

import vendingmachine.controller.MainController;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MainController mainController = new MainController(new InputView(), new OutputView());
        mainController.run();
    }
}
