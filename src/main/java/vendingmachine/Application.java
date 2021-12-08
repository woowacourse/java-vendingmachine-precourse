package vendingmachine;

import vendingmachine.Controller.VendingController;
import vendingmachine.View.InputView;

public class Application {
    public static void main(String[] args) {
        VendingController vendingController=new VendingController(new InputView());
        vendingController.start();
    }
}
