package vendingmachine.controller;

import vendingmachine.controller.handler.RetryHandler;
import vendingmachine.model.VendingMachine;
import vendingmachine.view.InputView;

public class VendingMachineController extends RetryHandler<VendingMachine> {

    @Override
    public VendingMachine doProcess() {
        return new VendingMachine(InputView.readTotalMoney());
    }
}
