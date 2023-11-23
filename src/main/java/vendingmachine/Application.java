package vendingmachine;

import vendingmachine.controller.InputManager;
import vendingmachine.controller.MachineController;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputManager inputManager = new InputManager(inputView, outputView);
        MachineController machineController = new MachineController(inputManager, outputView);
        machineController.run();
    }
}
