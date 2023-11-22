package vendingmachine;

import vendingmachine.controller.MachineController;
import vendingmachine.exception.RetryHandler;
import vendingmachine.service.CoinManager;
import vendingmachine.service.StockManager;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class Application {
    public static void main(String[] args) {
        MachineController machineController = new MachineController(
                new CoinManager(), new StockManager(), new InputView(), new OutputView(),
                new RetryHandler()
        );
        machineController.run();
    }
}
