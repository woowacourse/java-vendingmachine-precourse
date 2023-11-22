package vendingmachine;

import vendingmachine.controller.VendingMachineController;
import vendingmachine.view.Input;
import vendingmachine.view.InputView;

public class Application {
    public static void main(String[] args) {
        Input input = InputView.getInstance();
        VendingMachineController controller = VendingMachineController.from(input);
        controller.run();
    }
}
