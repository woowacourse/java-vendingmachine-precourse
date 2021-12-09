package vendingmachine;

import vendingmachine.Controller.VendingController;
import vendingmachine.View.*;

public class Application {
    public static void main(String[] args) {
        VendingController vendingController = new VendingController(new InputView(), new OutputView());
        vendingController.start();
    }
}
