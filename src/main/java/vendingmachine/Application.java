package vendingmachine;

import vendingmachine.controller.MachineController;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        MachineController machineController = new MachineController(inputView, outputView);
        machineController.play();
    }
}
