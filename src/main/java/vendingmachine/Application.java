package vendingmachine;

import vendingmachine.controller.MachineController;
import vendingmachine.service.StockManager;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MachineController machineController = new MachineController(
                new StockManager(), new InputView(), new OutputView()
        );
        machineController.run();
    }
}
